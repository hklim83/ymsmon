package com.ymsmonitoring.appserver.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Server extends AbstractModel<Long> {

    public String hostname;

	public String username;

	public String password;
	
    public String port;

    public String filename;
    
    public String path;
    
    public String command;
}
