package com.xworkz.emp.runner;

import com.xworkz.emp.entity.EmpMastEntity;
import com.xworkz.emp.service.EmployeeService;
import com.xworkz.emp.service.EmployeeServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class EmployeeRunner {

    public static void main(String[] args) {
        EmpMastEntity empMast = new EmpMastEntity();
        empMast.setEmpId(104);
        empMast.setName("Poonam");
        empMast.setDesig("Developer");
        empMast.setIdCard("ASWQ2345");
        empMast.setDob(LocalDate.of(2001, 11, 01));
        empMast.setDate_of_joining(LocalDate.of(2024, 03, 8));
        empMast.setAddr1("Raipur");
        empMast.setAddr2("Varansi");
        empMast.setMobile(8701239577l);
        empMast.setEmail("Poonam@gmail.com");
        empMast.setSysDate(LocalDate.now());

        EmployeeService service = new EmployeeServiceImpl();
        //service.saveEmpData(empMast);
//        EmpMastEntity updateMast = new EmpMastEntity();
//        updateMast.setMobile(8790123654l);
//        service.updatedData(updateMast);
        //service.getEmployee("Pune");
        List<String> list = service.getName();
        list.forEach((a) -> System.out.println(a));

        LocalDate date = service.getJoinDate(101);
        System.out.println("Date of joining is: " + date);

        //service.updateJoinDateDesigAddressById(LocalDate.of(2025,02,02), "Firemen","Chennai",103);
        // service.deleteData(104);
//        List<Object> list_of_designations =service.getDesignation();
//        list_of_designations.forEach(a-> System.out.println(a));
        List<Object[]> nameDesig = service.getNameDesignation();

        for (Object[] obj : nameDesig) {
           String nameList = (String) obj[0];
            String desig = (String) obj[0];
            System.out.println("Name: " + nameList+ "Desig"+desig);
        }

        System.out.println("Done");
    }

}
