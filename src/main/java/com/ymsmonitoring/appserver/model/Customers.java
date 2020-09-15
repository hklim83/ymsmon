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
public class Customers extends AbstractModel<Long> {

    public String firstname;

	public String lastname;

    public String email;

    public Date addedDate;

}
