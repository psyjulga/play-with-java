package userdatabase;

public interface StudentDatabase {
// interface => lists all methods to be implemented
// in any kind of databases
// e.g. textfile, sql db, .. => same methods needed
// but different implementation
// implementation of textfile database => FileStudentDatabase.java
public String[] readAllStudents() throws StudentDatabaseException;
  
public void addStudent(String name) throws StudentDatabaseException;

}
