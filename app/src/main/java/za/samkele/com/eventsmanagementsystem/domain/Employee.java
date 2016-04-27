package za.samkele.com.eventsmanagementsystem.domain;

import java.io.Serializable;

/**
 * Created by Samkele on 4/20/2016.
 */
public class Employee implements Serializable{
    private static final long serialVersionUID = 1L;
    private Long empId;
    private String firstName;
    private String lastName;
    private String employeeNumber;

    public void setEmpId(Long empId){
        this.empId = empId;
    }

    public Long getEmpId(){
        return empId;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmployeeNumber(){
        return employeeNumber;
    }

    private Employee() {

    }

    private Employee(Builder builder){
        this.empId = builder.empId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.employeeNumber = builder.employeeNumber;
    }

    public static class Builder {
        private Long empId;
        private String firstName;
        private String lastName;
        private String employeeNumber;

        public Builder empId(Long value) {
            this.empId = value;
            return this;
        }

        public Builder firstName(String value) {
            this.firstName = value;
            return this;
        }

        public Builder lastName(String value) {
            this.lastName = value;
            return this;
        }

        public Builder employeeNumber(String value) {
            this.employeeNumber = value;
            return this;
        }

        public Builder copy(Employee value) {
            this.empId = value.empId;
            this.firstName = value.firstName;
            this.lastName = value.lastName;
            this.employeeNumber = value.employeeNumber;
            return this;
        }

        public Employee build() {
            return new Employee (this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Employee))
            return false;

        Employee employee = (Employee) o;

        if (getEmpId() != null ? !getEmpId().equals(employee.getEmpId()) : employee.getEmpId() != null)
            return false;
        if (getFirstName() != null ? !getFirstName().equals(employee.getFirstName()) : employee.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(employee.getLastName()) : employee.getLastName() != null)
            return false;
        return !(getEmployeeNumber() != null ? !getEmployeeNumber().equals(employee.getEmployeeNumber()) : employee.getEmployeeNumber() != null);

    }

    @Override
    public int hashCode() {
        int result = getEmpId() != null ? getEmpId().hashCode() : 0;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getEmployeeNumber() != null ? getEmployeeNumber().hashCode() : 0);
        return result;
    }


    //@Override
        /*public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Employees employee = (Employees) o;

            if (!id.equals(employee.empId)) {
                return false;
            }
            return true;
        }*/

    // @Override
        /*public int hashCode(){
            return id.hashCode();
        }*/

}
