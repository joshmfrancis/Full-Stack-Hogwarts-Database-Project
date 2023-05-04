package Package;

import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Connection dbconn = null;
        Statement st = null;
        ResultSet rs = null;
        final String username = "root";
        final String password = "DaisyWoody800o@";
        String url = "jdbc:mysql://127.0.0.1:3306/CSC315FinalProject?autoReconnect=true&useSSL=false";

        try {
            // Connection to a database
            dbconn = DriverManager.getConnection(url, username, password);
            System.out.println("Hogwart's Database Connected! \n");

            char quit = 'n'; // Default for quit
            String input;
            int choice = 0; // Default for choice

            Scanner scan = new Scanner(System.in);

            while (quit != 'y') {
                System.out.println("""
                           -------------------------------------
                           Hogwart's Student Management Database
                           -------------------------------------
                           1.  Student
                           2.  Professor
                           3.  House
                           4.  House Tasks
                           5.  Course
                           6.  Course Materials
                           7.  Subject
                           8.  Enrollment Status
                           9.  Material Management
                           10. Custom Command
                           11. Exit
                           -----------------------------------
                           Enter In A Number To Access Options
                           -----------------------------------
                               """);

                choice = scan.nextInt();

                switch (choice) {

                    case 1 -> {
                        System.out.println("Chosen: Student");
                        // Student Search, List, Add, Remove,

                        char quit1 = 'n'; // Default for quit
                        String input1;
                        int choice1 = 0; // Default for choice
                        while (quit1 != 'y') {
                            System.out.println("""
                           ------------------------------------------------
                           Hogwart's Student Management Database -> Student
                           ------------------------------------------------
                           1.  Student Search
                           2.  List
                           3.  Add
                           4.  Remove
                           5.  Move Houses
                           6.  Exit
                           -----------------------------------
                           Enter In A Number To Access Options
                           -----------------------------------
                               """);

                            choice1 = scan.nextInt();

                            switch (choice1) {

                                case 1 -> {
                                    System.out.println("Chosen: Student Search");
                                    int selStudentID;

                                    //input data for selection
                                    System.out.print("Enter the Student ID Number to Select Its Related Record:");
                                    selStudentID = scan.nextInt();
                                    try {
                                        //select data from a table of a database/schema
                                        String stuquery = "select * from student where StudentID = '" + selStudentID + "'";
                                        PreparedStatement stuqueryst = dbconn.prepareStatement(stuquery);
                                        stuqueryst.executeQuery();
                                        rs = stuqueryst.executeQuery();
                                        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s%n",
                                                "StudentID",
                                                "FirstName",
                                                "MiddleName",
                                                "LastName",
                                                "DateOfBirth",
                                                "BloodType",
                                                "HouseID\n");                                        //3: Output the retrieved data /result set
                                        while (rs.next()) {
                                            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s%n",
                                                    rs.getString("StudentID"),
                                                    rs.getString("FirstName"),
                                                    rs.getString("MiddleName"),
                                                    rs.getString("LastName"),
                                                    rs.getString("DateOfBirth"),
                                                    rs.getString("BloodType"),
                                                    rs.getString("House_HouseID"));

                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been selected!");
                                    }
                                }

                                case 2 -> {
                                    System.out.println("Chosen: List");

                                    //1: Create a statement
                                    st = dbconn.createStatement();

                                    //2: Run a SQL query
                                    rs = st.executeQuery("select * from student");
                                    System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s%n",
                                            "StudentID",
                                            "FirstName",
                                            "MiddleName",
                                            "LastName",
                                            "DateOfBirth",
                                            "BloodType",
                                            "HouseID\n");
                                    //3: Output the retrieved data /result set
                                    while (rs.next()) {
                                        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s%n",
                                                rs.getString("StudentID"),
                                                rs.getString("FirstName"),
                                                rs.getString("MiddleName"),
                                                rs.getString("LastName"),
                                                rs.getString("DateOfBirth"),
                                                rs.getString("BloodType"),
                                                rs.getString("House_HouseID"));

                                    }
                                }

                                case 3 -> {
                                    System.out.println("Chosen: Add");

                                    int stuStudentID, stuHouse_HouseID;
                                    String stuFirstName, stuMiddleName, stuLastName, stuBloodType, stuDateOfBirth;

                                    //input data for insertion
                                    System.out.print("Enter Student's ID:");
                                    stuStudentID = scan.nextInt();
                                    System.out.print("Enter Student's Firstname:");
                                    stuFirstName = scan.next();
                                    System.out.print("Enter Student's Middlename:");
                                    stuMiddleName = scan.next();
                                    System.out.print("Enter Student's Lastname:");
                                    stuLastName = scan.next();
                                    System.out.print("Enter Student's Date Of Birth:");
                                    stuDateOfBirth = scan.next();
                                    System.out.print("Enter Student's Blood Type:");
                                    stuBloodType = scan.next();
                                    System.out.print("Enter Student's House ID:");
                                    stuHouse_HouseID = scan.nextInt();
                                    try {
                                        //insert data into a table of a database/schema
                                        String stuinsertq = "insert into student values ('" + stuStudentID + "','" + stuFirstName + "','" + stuMiddleName + "','" + stuLastName + "','" + stuDateOfBirth + "','" + stuBloodType + "','" + stuHouse_HouseID + "')";
                                        PreparedStatement stuinsertst = dbconn.prepareStatement(stuinsertq);
                                        stuinsertst.executeUpdate();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been inserted!");
                                    }
                                }

                                case 4 -> {
                                    System.out.println("Chosen: Remove");
                                    int delStudentID;

                                    //input data for deletion
                                    System.out.print("Enter the Student ID Number to Delete Its Related Record:");
                                    delStudentID = scan.nextInt();
                                    try {
                                        //delete data from a table of a database/schema
                                        String studeleteq = "delete from student where StudentID = '" + delStudentID + "'";
                                        PreparedStatement studeletest = dbconn.prepareStatement(studeleteq);
                                        studeletest.executeUpdate();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been deleted!");
                                    }
                                }

                                case 5 -> {
                                    System.out.println("Chosen: Move Houses");
                                    int modStudentID, modHouseID1;

                                    //input data for update
                                    System.out.print("Enter Student ID:");
                                    modStudentID = scan.nextInt();
                                    System.out.print("Enter New House ID:");
                                    modHouseID1 = scan.nextInt();
                                    try {
                                        //update data in a table of a database/schema
                                        String updateq1 = "update student set House_HouseID = '" + modHouseID1 + "' where StudentID = '" + modStudentID + "' ";
                                        PreparedStatement updatest1 = dbconn.prepareStatement(updateq1);
                                        updatest1.executeUpdate();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been updated!");
                                    }
                                }

                                case 6 -> {
                                    break;
                                }

                                default ->
                                    System.out.println("That was not a choice.");
                            }

                            System.out.println("Would you like to exit the Student subdirectory y/n?");
                            input1 = scan.next().toLowerCase();
                            quit1 = input1.charAt(0);
                        }

                    }

                    case 2 -> {
                        System.out.println("Chosen: Professor");
                        // Professor Search, List, Add, Remove,
                        char quit2 = 'n'; // Default for quit
                        String input2;
                        int choice2 = 0; // Default for choice
                        while (quit2 != 'y') {
                            System.out.println("""
                           --------------------------------------------------
                           Hogwart's Student Management Database -> Professor
                           --------------------------------------------------
                           1.  Professor Search
                           2.  List
                           3.  Add
                           4.  Remove
                           5.  Move Houses
                           6.  Exit
                           -----------------------------------
                           Enter In A Number To Access Options
                           -----------------------------------
                               """);

                            choice2 = scan.nextInt();

                            switch (choice2) {

                                case 1 -> {
                                    System.out.println("Chosen: Professor Search");
                                    int selProfessorID;

                                    //input data for selection
                                    System.out.print("Enter the Professor ID Number to Select Its Related Record:");
                                    selProfessorID = scan.nextInt();
                                    try {
                                        //select data from a table of a database/schema
                                        String proquery = "select * from professor where ProfessorID = '" + selProfessorID + "'";
                                        PreparedStatement proqueryst = dbconn.prepareStatement(proquery);
                                        proqueryst.executeQuery();
                                        rs = proqueryst.executeQuery();
                                        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s%n",
                                                "ProfessorID",
                                                "FirstName",
                                                "MiddleName",
                                                "LastName",
                                                "BloodType",
                                                "HouseID\n");
                                        //3: Output the retrieved data /result set
                                        while (rs.next()) {
                                            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s%n",
                                                    rs.getString("ProfessorID"),
                                                    rs.getString("FirstName"),
                                                    rs.getString("MiddleName"),
                                                    rs.getString("LastName"),
                                                    rs.getString("BloodType"),
                                                    rs.getString("House_HouseID"));

                                        }

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been selected!");
                                    }
                                }

                                case 2 -> {
                                    System.out.println("Chosen: List");
                                    //1: Create a statement
                                    st = dbconn.createStatement();

                                    //2: Run a SQL query
                                    rs = st.executeQuery("select * from professor");
                                    System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s%n",
                                            "ProfessorID",
                                            "FirstName",
                                            "MiddleName",
                                            "LastName",
                                            "BloodType",
                                            "HouseID\n");
                                    //3: Output the retrieved data /result set
                                    while (rs.next()) {
                                        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s%n",
                                                    rs.getString("ProfessorID"),
                                                    rs.getString("FirstName"),
                                                    rs.getString("MiddleName"),
                                                    rs.getString("LastName"),
                                                    rs.getString("BloodType"),
                                                    rs.getString("House_HouseID"));

                                    }
                                }

                                case 3 -> {
                                    System.out.println("Chosen: Add");

                                    int proProfessorID, proHouse_HouseID;
                                    String proFirstName, proMiddleName, proLastName, proBloodType;

                                    //input data for insertion
                                    System.out.print("Enter Professor's ID:");
                                    proProfessorID = scan.nextInt();
                                    System.out.print("Enter Professor's Firstname:");
                                    proFirstName = scan.next();
                                    System.out.print("Enter Professor's Middlename:");
                                    proMiddleName = scan.next();
                                    System.out.print("Enter Professor's Lastname:");
                                    proLastName = scan.next();
                                    System.out.print("Enter Professor's Blood Type:");
                                    proBloodType = scan.next();
                                    System.out.print("Enter Professor's House ID:");
                                    proHouse_HouseID = scan.nextInt();
                                    try {
                                        //insert data into a table of a database/schema
                                        String proinsertq = "insert into professor values ('" + proProfessorID + "','" + proFirstName + "','" + proMiddleName + "','" + proLastName + "','" + proBloodType + "','" + proHouse_HouseID + "')";
                                        PreparedStatement proinsertst = dbconn.prepareStatement(proinsertq);
                                        proinsertst.executeUpdate();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been inserted!");
                                    }
                                }

                                case 4 -> {
                                    System.out.println("Chosen: Remove");
                                    int delProfessorID;

                                    //input data for deletion
                                    System.out.print("Enter the Professor ID Number to Delete Its Related Record:");
                                    delProfessorID = scan.nextInt();
                                    try {
                                        //delete data from a table of a database/schema
                                        String prodeleteq = "delete from professor where ProfessorID = '" + delProfessorID + "'";
                                        PreparedStatement prodeletest = dbconn.prepareStatement(prodeleteq);
                                        prodeletest.executeUpdate();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been deleted!");
                                    }
                                }

                                case 5 -> {
                                    System.out.println("Chosen: Modify House");
                                    int modProfessorID, modHouseID2;

                                    //input data for update
                                    System.out.print("Enter Professor ID:");
                                    modProfessorID = scan.nextInt();
                                    System.out.print("Enter New House ID:");
                                    modHouseID2 = scan.nextInt();
                                    try {
                                        //update data in a table of a database/schema
                                        String updateq2 = "update professor set House_HouseID = '" + modHouseID2 + "' where ProfessorID = '" + modProfessorID + "' ";
                                        PreparedStatement updatest2 = dbconn.prepareStatement(updateq2);
                                        updatest2.executeUpdate();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been updated!");
                                    }
                                }

                                case 6 -> {
                                    break;
                                }

                                default ->
                                    System.out.println("That was not a choice.");
                            }

                            System.out.println("Would you like to exit the Professor subdirectory y/n?");
                            input2 = scan.next().toLowerCase();
                            quit2 = input2.charAt(0);
                        }
                    }

                    case 3 -> {
                        System.out.println("Chosen: House");
                        // House Search, List, Calculate house points,

                        char quit3 = 'n'; // Default for quit
                        String input3;
                        int choice3 = 0; // Default for choice
                        while (quit3 != 'y') {
                            System.out.println("""
                           ----------------------------------------------
                           Hogwart's Student Management Database -> House
                           ----------------------------------------------
                           1.  House Search
                           2.  List
                           3.  Add
                           4.  Remove
                           5.  Modify Points
                           6.  Exit
                           -----------------------------------
                           Enter In A Number To Access Options
                           -----------------------------------
                               """);

                            choice3 = scan.nextInt();

                            switch (choice3) {

                                case 1 -> {
                                    System.out.println("Chosen: House Search");
                                    int selHouseID;

                                    //input data for selection
                                    System.out.print("Enter the House ID Number to Select Its Related Record:");
                                    selHouseID = scan.nextInt();
                                    try {
                                        //select data from a table of a database/schema
                                        String houquery = "select * from house where HouseID = '" + selHouseID + "'";
                                        PreparedStatement houqueryst = dbconn.prepareStatement(houquery);
                                        houqueryst.executeQuery();
                                        rs = houqueryst.executeQuery();
                                        System.out.printf("%-15s %-15s %-15s%n",
                                                "HouseID",
                                                "HouseName",
                                                "HousePoints\n");
                                        //3: Output the retrieved data /result set
                                        while (rs.next()) {
                                            System.out.printf("%-15s %-15s %-15s%n",
                                                    rs.getString("HouseID"),
                                                    rs.getString("HouseName"),
                                                    rs.getString("HousePoints"));
                                        }

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been selected!");
                                    }
                                }

                                case 2 -> {
                                    System.out.println("Chosen: List");
                                    //1: Create a statement
                                    st = dbconn.createStatement();

                                    //2: Run a SQL query
                                    rs = st.executeQuery("select * from house");
                                    System.out.printf("%-15s %-15s %-15s%n",
                                            "HouseID",
                                            "HouseName",
                                            "HousePoints\n");
                                    //3: Output the retrieved data /result set
                                    while (rs.next()) {
                                        System.out.printf("%-15s %-15s %-15s%n",
                                                rs.getString("HouseID"),
                                                rs.getString("HouseName"),
                                                rs.getString("HousePoints"));
                                    }
                                }

                                case 3 -> {
                                    System.out.println("Chosen: Add");

                                    int houHouseID, houHousePoints;
                                    String houHouseName;

                                    //input data for insertion
                                    System.out.print("Enter House ID:");
                                    houHouseID = scan.nextInt();
                                    System.out.print("Enter House Name:");
                                    houHouseName = scan.next();
                                    System.out.print("Enter House Points:");
                                    houHousePoints = scan.nextInt();
                                    try {
                                        //insert data into a table of a database/schema
                                        String houinsertq = "insert into house values ('" + houHouseID + "','" + houHouseName + "','" + houHousePoints + "')";
                                        PreparedStatement houinsertst = dbconn.prepareStatement(houinsertq);
                                        houinsertst.executeUpdate();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been inserted!");
                                    }
                                }

                                case 4 -> {
                                    System.out.println("Chosen: Remove");
                                    int delHouseID;

                                    //input data for deletion
                                    System.out.print("Enter the House ID Number to Delete Its Related Record:");
                                    delHouseID = scan.nextInt();
                                    try {
                                        //delete data from a table of a database/schema
                                        String houdeleteq = "delete from house where HouseID = '" + delHouseID + "'";
                                        PreparedStatement houdeletest = dbconn.prepareStatement(houdeleteq);
                                        houdeletest.executeUpdate();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been deleted!");
                                    }
                                }

                                case 5 -> {
                                    System.out.println("Chosen: Modify Points:");
                                    int addingHousePoints, addingHouseID;

                                    //input data for update
                                    System.out.print("House ID of the House That Is Recieving/Removing Points:");
                                    addingHouseID = scan.nextInt();
                                    System.out.print("Amount Of Points That House To Add/Remove:");
                                    addingHousePoints = scan.nextInt();
                                    try {
                                        //update data in a table of a database/schema
                                        String updateq3 = "update house set HousePoints = HousePoints + '" + addingHousePoints + "' where HouseID = '" + addingHouseID + "' ";
                                        PreparedStatement updatest3 = dbconn.prepareStatement(updateq3);
                                        updatest3.executeUpdate();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been updated!");
                                    }

                                }

                                case 6 -> {
                                    break;
                                }

                                default ->
                                    System.out.println("That was not a choice.");
                            }

                            System.out.println("Would you like to exit the House subdirectory y/n?");
                            input3 = scan.next().toLowerCase();
                            quit3 = input3.charAt(0);
                        }
                    }

                    case 4 -> {
                        System.out.println("Chosen: House Tasks");
                        // House Task Search, List, Add, Remove,
                        char quit4 = 'n'; // Default for quit
                        String input4;
                        int choice4 = 0; // Default for choice
                        while (quit4 != 'y') {
                            System.out.println("""
                           ----------------------------------------------------
                           Hogwart's Student Management Database -> House Tasks
                           ----------------------------------------------------
                           1.  House Tasks Search
                           2.  List
                           3.  Add
                           4.  Remove
                           5.  Exit
                           -----------------------------------
                           Enter In A Number To Access Options
                           -----------------------------------
                               """);

                            choice4 = scan.nextInt();

                            switch (choice4) {

                                case 1 -> {
                                    System.out.println("Chosen: House Tasks Search");
                                    String selTaskName;

                                    //input data for selection
                                    scan.nextLine();
                                    System.out.print("Enter the Task Name to Select Its Related Record:");
                                    selTaskName = scan.nextLine();
                                    try {
                                        //select data from a table of a database/schema
                                        String tasquery = "select * from tasks where TaskName = '" + selTaskName + "'";
                                        PreparedStatement tasqueryst = dbconn.prepareStatement(tasquery);
                                        tasqueryst.executeQuery();
                                        rs = tasqueryst.executeQuery();
                                        System.out.printf("%-25s %-25s %-25s%n",
                                                "TaskName",
                                                "LastDateCompleted",
                                                "HouseID\n");
                                        //3: Output the retrieved data /result set
                                        while (rs.next()) {
                                            System.out.printf("%-25s %-25s %-25s%n",
                                                    rs.getString("TaskName"),
                                                    rs.getString("LastDateCompleted"),
                                                    rs.getString("House_HouseID"));
                                        }

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been selected!");
                                    }
                                }

                                case 2 -> {
                                    System.out.println("Chosen: List");
                                    //1: Create a statement
                                    st = dbconn.createStatement();

                                    //2: Run a SQL query
                                    rs = st.executeQuery("select * from tasks");
                                    System.out.printf("%-25s %-25s %-25s%n",
                                            "TaskName",
                                            "LastDateCompleted",
                                            "HouseID\n");
                                    //3: Output the retrieved data /result set
                                    while (rs.next()) {
                                        System.out.printf("%-25s %-25s %-25s%n",
                                                rs.getString("TaskName"),
                                                rs.getString("LastDateCompleted"),
                                                rs.getString("House_HouseID"));
                                    }
                                }

                                case 3 -> {
                                    System.out.println("Chosen: Add");

                                    int tasHouseID;
                                    String tasTaskName, tasLastDateCompleted;

                                    //input data for insertion
                                    scan.nextLine();
                                    System.out.print("Enter Task Name:");
                                    tasTaskName = scan.nextLine();
                                    System.out.print("Enter Last Date That Task Was Completed:");
                                    tasLastDateCompleted = scan.next();
                                    System.out.print("Enter House ID:");
                                    tasHouseID = scan.nextInt();
                                    try {
                                        //insert data into a table of a database/schema
                                        String tasinsertq = "insert into tasks values ('" + tasTaskName + "','" + tasLastDateCompleted + "','" + tasHouseID + "')";
                                        PreparedStatement tasinsertst = dbconn.prepareStatement(tasinsertq);
                                        tasinsertst.executeUpdate();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been inserted!");
                                    }
                                }

                                case 4 -> {
                                    System.out.println("Chosen: Remove");
                                    String delTaskName;

                                    //input data for deletion
                                    scan.nextLine();
                                    System.out.print("Enter the Task Name to Delete Its Related Record:");
                                    delTaskName = scan.nextLine();
                                    try {
                                        //delete data from a table of a database/schema
                                        String tasdeleteq = "delete from tasks where TaskName = '" + delTaskName + "'";
                                        PreparedStatement tasdeletest = dbconn.prepareStatement(tasdeleteq);
                                        tasdeletest.executeUpdate();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been deleted!");
                                    }

                                }

                                case 5 -> {
                                    break;
                                }

                                default ->
                                    System.out.println("That was not a choice.");
                            }

                            System.out.println("Would you like to exit the House Tasks subdirectory y/n?");
                            input4 = scan.next().toLowerCase();
                            quit4 = input4.charAt(0);
                        }
                    }

                    case 5 -> {
                        System.out.println("Chosen: Course");
                        // Course Search, List, Add, Remove,
                        char quit5 = 'n'; // Default for quit
                        String input5;
                        int choice5 = 0; // Default for choice
                        while (quit5 != 'y') {
                            System.out.println("""
                           -----------------------------------------------
                           Hogwart's Student Management Database -> Course
                           -----------------------------------------------
                           1.  Course Search
                           2.  List
                           3.  Add
                           4.  Remove
                           5.  Exit
                           -----------------------------------
                           Enter In A Number To Access Options
                           -----------------------------------
                               """);

                            choice5 = scan.nextInt();

                            switch (choice5) {

                                case 1 -> {
                                    System.out.println("Chosen: Course Search");
                                    int selCourseID;

                                    //input data for selection
                                    System.out.print("Enter the Course ID Number to Select Its Related Record:");
                                    selCourseID = scan.nextInt();
                                    try {
                                        //select data from a table of a database/schema
                                        String couquery = "select * from course where CourseID = '" + selCourseID + "'";
                                        PreparedStatement couqueryst = dbconn.prepareStatement(couquery);
                                        couqueryst.executeQuery();
                                        System.out.printf("%-35s %-35s %-35s %-35s %-35s %-35s %-35s%n",
                                                "CourseID",
                                                "CourseName",
                                                "StartDate",
                                                "EndDate",
                                                "RoomNumber",
                                                "ProfessorID",
                                                "SubjectID\n");
                                        rs = couqueryst.executeQuery();
                                        while (rs.next()) {
                                            System.out.printf("%-35s %-35s %-35s %-35s %-35s %-35s %-35s%n",
                                                    rs.getString("CourseID"),
                                                    rs.getString("CourseName"),
                                                    rs.getString("StartDate"),
                                                    rs.getString("EndDate"),
                                                    rs.getString("RoomNumber"),
                                                    rs.getString("Professor_ProfessorID"),
                                                    rs.getString("Subject_SubjectID"));
                                        }

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been selected!");
                                    }
                                }

                                case 2 -> {
                                    System.out.println("Chosen: List");
                                    //1: Create a statement
                                    st = dbconn.createStatement();

                                    //2: Run a SQL query
                                    rs = st.executeQuery("select * from course");
                                    System.out.printf("%-35s %-35s %-35s %-35s %-35s %-35s %-35s%n",
                                            "CourseID",
                                            "CourseName",
                                            "StartDate",
                                            "EndDate",
                                            "RoomNumber",
                                            "ProfessorID",
                                            "SubjectID\n");
                                    //3: Output the retrieved data /result set
                                    while (rs.next()) {
                                        System.out.printf("%-35s %-35s %-35s %-35s %-35s %-35s %-35s%n",
                                                rs.getString("CourseID"),
                                                rs.getString("CourseName"),
                                                rs.getString("StartDate"),
                                                rs.getString("EndDate"),
                                                rs.getString("RoomNumber"),
                                                rs.getString("Professor_ProfessorID"),
                                                rs.getString("Subject_SubjectID"));
                                    }
                                }

                                case 3 -> {
                                    System.out.println("Chosen: Add");

                                    int couCourseID, couProfessorID, couSubjectID;
                                    String couCourseName, couStartDate, couEndDate, couRoomNumber;

                                    //input data for insertion
                                    System.out.print("Enter Course ID:");
                                    couCourseID = scan.nextInt();
                                    scan.nextLine();
                                    System.out.print("Enter Course Name:");
                                    couCourseName = scan.nextLine();
                                    System.out.print("Enter Course Start Date:");
                                    couStartDate = scan.next();
                                    System.out.print("Enter Course End Date:");
                                    couEndDate = scan.next();
                                    scan.nextLine();
                                    System.out.print("Enter Course Room Number:");
                                    couRoomNumber = scan.nextLine();
                                    System.out.print("Enter Professor ID Of Which Professor Is Teaching The Course:");
                                    couProfessorID = scan.nextInt();
                                    System.out.print("Enter Subject ID Of The Course:");
                                    couSubjectID = scan.nextInt();

                                    try {
                                        //insert data into a table of a database/schema
                                        String couinsertq = "insert into course values ('" + couCourseID + "','" + couCourseName + "','" + couStartDate + "','" + couEndDate + "','" + couRoomNumber + "','" + couProfessorID + "','" + couSubjectID + "')";
                                        PreparedStatement couinsertst = dbconn.prepareStatement(couinsertq);
                                        couinsertst.executeUpdate();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been inserted!");
                                    }
                                }

                                case 4 -> {
                                    System.out.println("Chosen: Remove");
                                    int delCourseID;

                                    //input data for deletion
                                    System.out.print("Enter the Course ID Number to Delete Its Related Record:");
                                    delCourseID = scan.nextInt();
                                    try {
                                        //delete data from a table of a database/schema
                                        String coudeleteq = "delete from course where CourseID = '" + delCourseID + "'";
                                        PreparedStatement coudeletest = dbconn.prepareStatement(coudeleteq);
                                        coudeletest.executeUpdate();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been deleted!");
                                    }
                                }

                                case 5 -> {
                                    break;
                                }

                                default ->
                                    System.out.println("That was not a choice.");
                            }

                            System.out.println("Would you like to exit the Course subdirectory y/n?");
                            input5 = scan.next().toLowerCase();
                            quit5 = input5.charAt(0);
                        }
                    }

                    case 6 -> {
                        System.out.println("Chosen: Course Materials");
                        // Course Search, List, Add, Remove,
                        char quit6 = 'n'; // Default for quit
                        String input6;
                        int choice6 = 0; // Default for choice
                        while (quit6 != 'y') {
                            System.out.println("""
                           ---------------------------------------------------------
                           Hogwart's Student Management Database -> Course Materials
                           ---------------------------------------------------------
                           1.  Course Materials Search
                           2.  List
                           3.  Add
                           4.  Remove
                           5.  Exit
                           -----------------------------------
                           Enter In A Number To Access Options
                           -----------------------------------
                               """);

                            choice6 = scan.nextInt();

                            switch (choice6) {

                                case 1 -> {
                                    System.out.println("Chosen: Course Materials Search");
                                    int selMaterialID;

                                    //input data for selection
                                    System.out.print("Enter the Material ID Number to Select Its Related Record:");
                                    selMaterialID = scan.nextInt();
                                    try {
                                        //select data from a table of a database/schema
                                        String matquery = "select * from material where MaterialID = '" + selMaterialID + "'";
                                        PreparedStatement matqueryst = dbconn.prepareStatement(matquery);
                                        matqueryst.executeQuery();
                                        rs = matqueryst.executeQuery();
                                        System.out.printf("%-15s %-15s %-15s%n",
                                                "MaterialID",
                                                "MaterialType",
                                                "MaterialName\n");
                                        //3: Output the retrieved data /result set
                                        while (rs.next()) {
                                            System.out.printf("%-15s %-15s %-15s%n",
                                                    rs.getString("MaterialID"),
                                                    rs.getString("MaterialType"),
                                                    rs.getString("MaterialName"));

                                        }

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been selected!");
                                    }
                                }

                                case 2 -> {
                                    System.out.println("Chosen: List");
                                    //1: Create a statement
                                    st = dbconn.createStatement();

                                    //2: Run a SQL query
                                    rs = st.executeQuery("select * from material");
                                    System.out.printf("%-15s %-15s %-15s%n",
                                            "MaterialID",
                                            "MaterialType",
                                            "MaterialName\n");
                                    //3: Output the retrieved data /result set
                                    while (rs.next()) {
                                        System.out.printf("%-15s %-15s %-15s%n",
                                                rs.getString("MaterialID"),
                                                rs.getString("MaterialType"),
                                                rs.getString("MaterialName"));

                                    }
                                }

                                case 3 -> {
                                    System.out.println("Chosen: Add");

                                    int matMaterialID;
                                    String matMaterialType, matMaterialName;

                                    //input data for insertion
                                    System.out.print("Enter Material ID:");
                                    matMaterialID = scan.nextInt();
                                    scan.nextLine();
                                    System.out.print("Enter Material Type:");
                                    matMaterialType = scan.nextLine();
                                    scan.nextLine();
                                    System.out.print("Enter Material Name:");
                                    matMaterialName = scan.nextLine();
                                    try {
                                        //insert data into a table of a database/schema
                                        String matinsertq = "insert into material values ('" + matMaterialID + "','" + matMaterialType + "','" + matMaterialName + "')";
                                        PreparedStatement matinsertst = dbconn.prepareStatement(matinsertq);
                                        matinsertst.executeUpdate();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been inserted!");
                                    }
                                }

                                case 4 -> {
                                    System.out.println("Chosen: Remove");
                                    int delMaterialID;

                                    //input data for deletion
                                    System.out.print("Enter the Material ID Number to Delete Its Related Record:");
                                    delMaterialID = scan.nextInt();
                                    try {
                                        //delete data from a table of a database/schema
                                        String matdeleteq = "delete from material where MaterialID = '" + delMaterialID + "'";
                                        PreparedStatement matdeletest = dbconn.prepareStatement(matdeleteq);
                                        matdeletest.executeUpdate();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been deleted!");
                                    }
                                }

                                case 5 -> {
                                    break;
                                }

                                default ->
                                    System.out.println("That was not a choice.");
                            }

                            System.out.println("Would you like to exit the Course Materials subdirectory y/n?");
                            input6 = scan.next().toLowerCase();
                            quit6 = input6.charAt(0);
                        }
                    }

                    case 7 -> {
                        System.out.println("Chosen: Subject");
                        // Subject Search, List, Add, Remove,
                        char quit7 = 'n'; // Default for quit
                        String input7;
                        int choice7 = 0; // Default for choice
                        while (quit7 != 'y') {
                            System.out.println("""
                           ------------------------------------------------
                           Hogwart's Student Management Database -> Subject
                           ------------------------------------------------
                           1.  Subject Search
                           2.  List
                           3.  Add
                           4.  Remove
                           5.  Exit
                           -----------------------------------
                           Enter In A Number To Access Options
                           -----------------------------------
                               """);

                            choice7 = scan.nextInt();

                            switch (choice7) {

                                case 1 -> {
                                    System.out.println("Chosen: Subject Search");
                                    int selSubjectID;

                                    //input data for selection
                                    System.out.print("Enter the Subject ID Number to Select Its Related Record:");
                                    selSubjectID = scan.nextInt();
                                    try {
                                        //select data from a table of a database/schema
                                        String subquery = "select * from subject where SubjectID = '" + selSubjectID + "'";
                                        PreparedStatement subqueryst = dbconn.prepareStatement(subquery);
                                        subqueryst.executeQuery();
                                        rs = subqueryst.executeQuery();
                                        System.out.printf("%-40s %-40s %-40s%n",
                                                "SubjectID",
                                                "SubjectName",
                                                "LastDateOffered\n");

                                        //3: Output the retrieved data /result set
                                        while (rs.next()) {
                                            System.out.printf("%-40s %-40s %-40s%n",
                                                    rs.getString("SubjectID"),
                                                    rs.getString("SubjectName"),
                                                    rs.getString("LastDateOffered"));
                                        }

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been selected!");
                                    }
                                }

                                case 2 -> {
                                    System.out.println("Chosen: List");
                                    //1: Create a statement
                                    st = dbconn.createStatement();

                                    //2: Run a SQL query
                                    rs = st.executeQuery("select * from subject");
                                    System.out.printf("%-40s %-40s %-40s%n",
                                            "SubjectID",
                                            "SubjectName",
                                            "LastDateOffered\n");

                                    //3: Output the retrieved data /result set
                                    while (rs.next()) {
                                        System.out.printf("%-40s %-40s %-40s%n",
                                                rs.getString("SubjectID"),
                                                rs.getString("SubjectName"),
                                                rs.getString("LastDateOffered"));
                                    }
                                }

                                case 3 -> {
                                    System.out.println("Chosen: Add");

                                    int subSubjectID;
                                    String subSubjectName, subLastDateOffered;

                                    //input data for insertion
                                    System.out.print("Enter Subject ID:");
                                    subSubjectID = scan.nextInt();
                                    scan.nextLine();
                                    System.out.print("Enter Subject Name:");
                                    subSubjectName = scan.nextLine();
                                    System.out.print("Enter Last Date That Subject Was Offered:");
                                    subLastDateOffered = scan.next();
                                    try {
                                        //insert data into a table of a database/schema
                                        String subinsertq = "insert into subject values ('" + subSubjectID + "','" + subSubjectName + "','" + subLastDateOffered + "')";
                                        PreparedStatement subinsertst = dbconn.prepareStatement(subinsertq);
                                        subinsertst.executeUpdate();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been inserted!");
                                    }
                                }

                                case 4 -> {
                                    System.out.println("Chosen: Remove");
                                    int delSubjectID;

                                    //input data for deletion
                                    System.out.print("Enter the Subject ID Number to Delete Its Related Record:");
                                    delSubjectID = scan.nextInt();
                                    try {
                                        //delete data from a table of a database/schema
                                        String subdeleteq = "delete from subject where SubjectID = '" + delSubjectID + "'";
                                        PreparedStatement subdeletest = dbconn.prepareStatement(subdeleteq);
                                        subdeletest.executeUpdate();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been deleted!");
                                    }
                                }

                                case 5 -> {
                                    break;
                                }

                                default ->
                                    System.out.println("That was not a choice.");
                            }

                            System.out.println("Would you like to exit the Subject subdirectory y/n?");
                            input7 = scan.next().toLowerCase();
                            quit7 = input7.charAt(0);
                        }
                    }

                    case 8 -> {
                        System.out.println("Chosen: Enrollment Status");
                        char quit8 = 'n'; // Default for quit
                        String input8;
                        int choice8 = 0; // Default for choice
                        while (quit8 != 'y') {
                            System.out.println("""
                            ----------------------------------------------------------
                            Hogwart's Student Management Database -> Enrollment Status
                            ----------------------------------------------------------
                            1.  Enrollment Search
                            2.  List
                            3.  Add
                            4.  Remove
                            5.  Exit
                            -----------------------------------
                            Enter In A Number To Access Options
                            -----------------------------------
                                              """);

                            choice8 = scan.nextInt();

                            switch (choice8) {

                                case 1 -> {
                                    System.out.println("Chosen: Enrollment Search");
                                    int selStudentID, selCourseID;

                                    //input data for selection
                                    System.out.print("Enter the Student ID Number to Select Its Related Record:");
                                    selStudentID = scan.nextInt();
                                    System.out.print("Enter the Course ID Number to Select Its Related Record:");
                                    selCourseID = scan.nextInt();
                                    try {
                                        //select data from a table of a database/schema
                                        String enrollquery = "select * from enrolls where Student_StudentID = ? and Course_CourseID = ?";
                                        PreparedStatement enrollqueryst = dbconn.prepareStatement(enrollquery);
                                        enrollqueryst.setInt(1, selStudentID);
                                        enrollqueryst.setInt(2, selCourseID);
                                        rs = enrollqueryst.executeQuery();
                                        System.out.printf("%-20s %-20s %-20s %-20s%n",
                                                "StudentID",
                                                "CourseID",
                                                "DateOfEnrollment",
                                                "EnrollmentStatus\n");
                                        //3: Output the retrieved data /result set
                                        while (rs.next()) {
                                            System.out.printf("%-20s %-20s %-20s %-20s%n",
                                                    rs.getInt("Student_StudentID"),
                                                    rs.getInt("Course_CourseID"),
                                                    rs.getString("DateOfEnrollment"),
                                                    rs.getString("EnrollmentStatus"));
                                        }

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been selected!");
                                    }
                                }

                                case 2 -> {
                                    System.out.println("Chosen: List");
                                    //1: Create a statement
                                    st = dbconn.createStatement();

                                    //2: Run a SQL query
                                    rs = st.executeQuery("select * from enrolls");
                                    System.out.printf("%-20s %-20s %-20s %-20s%n",
                                            "StudentID",
                                            "CourseID",
                                            "DateOfEnrollment",
                                            "EnrollmentStatus\n");
                                    //3: Output the retrieved data /result set
                                    while (rs.next()) {
                                        System.out.printf("%-20s %-20s %-20s %-20s%n",
                                                rs.getInt("Student_StudentID"),
                                                rs.getInt("Course_CourseID"),
                                                rs.getString("DateOfEnrollment"),
                                                rs.getString("EnrollmentStatus"));
                                    }
                                }
                                case 3 -> {
                                    System.out.println("Chosen: Add");

                                    int studentID;
                                    int courseID;
                                    String dateOfEnrollment;
                                    String enrollmentStatus;

                                    //input data for insertion
                                    System.out.print("Enter Student ID:");
                                    studentID = scan.nextInt();
                                    System.out.print("Enter Course ID:");
                                    courseID = scan.nextInt();
                                    scan.nextLine();
                                    System.out.print("Enter Date of Enrollment:");
                                    dateOfEnrollment = scan.nextLine();
                                    System.out.print("Enter Enrollment Status:");
                                    enrollmentStatus = scan.nextLine();

                                    try {
                                        //insert data into a table of a database/schema
                                        String insertQuery = "insert into enrolls values ('" + studentID + "','" + courseID + "','" + dateOfEnrollment + "','" + enrollmentStatus + "')";
                                        PreparedStatement insertStatement = dbconn.prepareStatement(insertQuery);
                                        insertStatement.executeUpdate();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been inserted!");
                                    }
                                }

                                case 4 -> {
                                    System.out.println("Chosen: Remove");

                                    int studentID;
                                    int courseID;

                                    //input data for deletion
                                    System.out.print("Enter the Student ID:");
                                    studentID = scan.nextInt();
                                    System.out.print("Enter the Course ID:");
                                    courseID = scan.nextInt();

                                    try {
                                        //delete data from a table of a database/schema
                                        String deleteQuery = "delete from enrolls where Student_StudentID = '" + studentID + "' and Course_CourseID = '" + courseID + "'";
                                        PreparedStatement deleteStatement = dbconn.prepareStatement(deleteQuery);
                                        deleteStatement.executeUpdate();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been deleted!");
                                    }
                                }

                                case 5 -> {
                                    break;
                                }

                                default ->
                                    System.out.println("That was not a choice.");
                            }

                            System.out.println("Would you like to exit the Enrollment subdirectory y/n?");
                            input8 = scan.next().toLowerCase();
                            quit8 = input8.charAt(0);
                        }

                    }
                    case 9 -> {
                        System.out.println("Chosen: Material Management");
                        char quit9 = 'n'; // Default for quit
                        String input9;
                        int choice9 = 0; // Default for choice
                        while (quit9 != 'y') {
                            System.out.println("""
                            ------------------------------------------------------------
                            Hogwart's Course Management Database -> Materials Management
                            ------------------------------------------------------------
                            1.  Materials Management Search
                            2.  List
                            3.  Add
                            4.  Remove
                            5.  Exit
                            -----------------------------------
                            Enter In A Number To Access Options
                            -----------------------------------
                                               """);

                            choice9 = scan.nextInt();

                            switch (choice9) {

                                case 1 -> {
                                    System.out.println("Chosen: Materials Management Search");
                                    int selCourseID, selMaterialID;

                                    //input data for selection
                                    System.out.print("Enter the Course ID Number to Select Its Related Record:");
                                    selCourseID = scan.nextInt();
                                    System.out.print("Enter the Material ID Number to Select Its Related Record:");
                                    selMaterialID = scan.nextInt();
                                    try {
                                        //select data from a table of a database/schema
                                        String reqquery = "select * from requires where Course_CourseID = ? and Material_MaterialID = ?";
                                        PreparedStatement reqqueryst = dbconn.prepareStatement(reqquery);
                                        reqqueryst.setInt(1, selCourseID);
                                        reqqueryst.setInt(2, selMaterialID);
                                        rs = reqqueryst.executeQuery();
                                        System.out.printf("%-15s %-15s%n",
                                                "CourseID",
                                                "MaterialID\n");
                                        //3: Output the retrieved data /result set
                                        while (rs.next()) {
                                            System.out.printf("%-15d %-15d%n",
                                                    rs.getInt("Course_CourseID"),
                                                    rs.getInt("Material_MaterialID"));
                                        }

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been selected!");
                                    }
                                }

                                case 2 -> {
                                    System.out.println("Chosen: List");
                                    //1: Create a statement
                                    st = dbconn.createStatement();

                                    //2: Run a SQL query
                                    rs = st.executeQuery("select * from requires");
                                    System.out.printf("%-15s %-15s%n",
                                            "CourseID",
                                            "MaterialID\n");
                                    //3: Output the retrieved data /result set
                                    while (rs.next()) {
                                        System.out.printf("%-15d %-15d%n",
                                                rs.getInt("Course_CourseID"),
                                                rs.getInt("Material_MaterialID"));
                                    }
                                }
                                case 3 -> {
                                    System.out.println("Chosen: Add");

                                    int courseID;
                                    int materialID;

                                    //input data for insertion
                                    System.out.print("Enter Course ID:");
                                    courseID = scan.nextInt();
                                    System.out.print("Enter Material ID:");
                                    materialID = scan.nextInt();

                                    try {
                                        //insert data into a table of a database/schema
                                        String insertQuery = "insert into requires values (?, ?)";
                                        PreparedStatement insertStatement = dbconn.prepareStatement(insertQuery);
                                        insertStatement.setInt(1, courseID);
                                        insertStatement.setInt(2, materialID);
                                        insertStatement.executeUpdate();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been inserted!");
                                    }
                                }

                                case 4 -> {
                                    System.out.println("Chosen: Remove");

                                    int courseID;
                                    int materialID;

                                    //input data for deletion
                                    System.out.print("Enter the Course ID:");
                                    courseID = scan.nextInt();
                                    System.out.print("Enter the Material ID:");
                                    materialID = scan.nextInt();

                                    try {
                                        //delete data from a table of a database/schema
                                        String deleteQuery = "delete from requires where Course_CourseID = ? and Material_MaterialID = ?";
                                        PreparedStatement deleteStatement = dbconn.prepareStatement(deleteQuery);
                                        deleteStatement.setInt(1, courseID);
                                        deleteStatement.setInt(2, materialID);
                                        deleteStatement.executeUpdate();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        System.out.println("The record has been deleted!");
                                    }
                                }

                                case 5 -> {
                                    break;
                                }

                                default ->
                                    System.out.println("That was not a choice.");
                            }

                            System.out.println("Would you like to exit the Materials Management subdirectory y/n?");
                            input9 = scan.next().toLowerCase();
                            quit9 = input9.charAt(0);
                        }

                    }

                    case 10 -> {
                        System.out.println("Chosen: Custom Command");
                        scan.nextLine();
                        System.out.print("Enter in your custom SQL command:");
                        String customCommand = scan.nextLine();
                        String preparedCustomCommand = ("""
                                                        """ + customCommand + """
                                                                             """);
                        try {
                            st = dbconn.createStatement();

                            //1: Run a SQL query
                            rs = st.executeQuery(preparedCustomCommand);

                            //2: Output the retrieved data /result set
                            while (rs.next()) {
                                ResultSetMetaData rsmd = rs.getMetaData();
                                int cusColumn = rsmd.getColumnCount();
                                for (int i = 1; i <= cusColumn; i++) {
                                    if (i > 1) {
                                        System.out.print("\t");
                                    }
                                    String cusColumnValue = rs.getString(i);
                                    System.out.printf("%-30s", cusColumnValue);
                                }
                                System.out.println();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            System.out.println("Custom command has been run!");
                        }

                    }

                    case 11 -> {
                        System.out.println("Exiting Hogwart's Database!");
                        System.exit(0);

                    }
                    default ->
                        System.out.println("That was not a choice.");
                }

                System.out.println("Would you like to exit the database y/n?");
                input = scan.next().toLowerCase();
                quit = input.charAt(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Exiting Hogwart's Database!");
    }

}
