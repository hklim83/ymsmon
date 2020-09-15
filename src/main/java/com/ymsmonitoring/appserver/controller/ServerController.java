package com.ymsmonitoring.appserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ymsmonitoring.appserver.model.Server;
import com.ymsmonitoring.appserver.service.ServerService;

@Controller
@RequestMapping("server")
public class ServerController {

    private ServerService serverService;

    @Autowired
    public void setServerService(ServerService serverService) {
        this.serverService = serverService;
    }

    @GetMapping("/test")
    public String test(Model model) {
        Page<Server> page = serverService.getList(1);
        model.addAttribute("server", new Server());
        return "server/test";
    }
    
    @GetMapping
    public String index() {
        return "redirect:/server/1";
    }

    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Server> page = serverService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "server/list";

    }

    @GetMapping("/add")
    public String add(Model model) {

        model.addAttribute("server", new Server());
        return "server/form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        model.addAttribute("server", serverService.get(id));
        return "server/form";

    }

    @PostMapping(value = "/save")
    public String save(Server server, final RedirectAttributes ra) {

    	Server save = serverService.save(server);
        ra.addFlashAttribute("successFlash", "Cliente foi salvo com sucesso.");
        return "redirect:/server";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

    	serverService.delete(id);
        return "redirect:/server";

    }

}
