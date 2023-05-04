Created: 04/13/2023

This is a full-stack database project that I created modeling the Hogwarts School of Witchcraft and Wizardry. 
This project was made for my CSC 315 course.

Abstract:

This database is a model of the Hogwarts School of Witchcraft and Wizardry.
The database stores information on everything that pertains to the upkeep of
Hogwarts and the management of its many assets. These assets include students,
students’ enrollment status in courses, subjects, professors, Houses, House
tasks, courses, course requirements for materials, and materials. Utilizing this
information in this database, a Hogwarts employee could manage what students
are taking what courses, the professor that is teaching that course, the material
that is provided in that course, the subject that course comes from, the House
the professor and student are in, and what tasks that House has to complete on a
weekly basis. This program takes into account all previously mentioned
functionality, along with searching, listing, adding, and removing said entities
from the database. The employees of Hogwarts also have full control of the
database through the custom commands feature. Magic is just highly developed
technology, and it is my hope that this database would be a part of the magic at
the Hogwarts School of Witchcraft and Wizardry.

Requirement Analysis:

The target audience for this project is employees of the Hogwarts School of
Witchcraft and Wizardry. We cater to this audience by providing them with
complete control over the content and structure of Houses, students, professors,
courses, subjects, materials, and House tasks. Our database implementation
provides full functionality over the many assets that Hogwarts requires to
function. This is achieved by including the following tables in our database:
The Student table keeps track of all of the information required by a student at
Hogwarts, including their Student ID number (primary key), first name, middle
name, last name, date of birth, blood type, and House ID of their assigned
House (foreign key).
The Professor table keeps track of each Hogwarts professor’s ID (primary key),
first name, middle name, last name, blood type, and House ID of their assigned
House (foreign key).
The House table holds information pertaining to the House that the Students,
Professors, and tasks are in by including a HouseID (primary key), House
Name, and House Points.
The Tasks table holds the information necessary to section off tasks to students
of each House by having records for the task name (primary key), the last date
the task was completed, and the House ID that the task is designated for (foreign
key).
The Enrolls table is responsible for matching a student to a course by holding
the following information about the enrollment status of a student: The student’s
ID number (part of the composite key), the course’s ID they registered for (part
of the composite key), the date of enrollment into the course, and enrollment
status of that course.
The Course table is responsible for keeping track of all of the information
needed by a student that enrolls in a course, including the course’s ID (primary
key), the course’s name, the start date of that course, the end date of that course,
the room number of where that course takes place, the professor’s ID for who it
teaching that course (foreign key), and the subject ID pertaining to the category
of the course (foreign key).
The Requires table is responsible for matching a course to the materials needed
by that course. It does this by keeping track of the following information: the
course’s ID (part of the composite key), and the material’s ID (part of the
composite key).
The Material table is responsible for keeping track of all of the materials needed
for courses at Hogwarts. The information that is tracked is the material’s ID
(primary key), the material’s type, and the material’s name.
The Subject table holds information that pertains to the overall subject of each
course. This information includes the subject’s ID (primary key), the subject’s
name, and the last date that that subject had a course in its scope that was
offered.

Assumptions:

Our assumptions in our database come from the inclusion of primary keys and
foreign keys.
The House table has a primary key, HouseID, and has a foreign key in the
tables: Student, Professor, and Tasks. This creates a one-to-many relationship
between House and Student/Professor/Tasks. Where one House has many tasks,
but one task belongs to exclusively one House. Many professors can be a part of
one House, but each professor can only be a part of one House. Many students
can be a part of one House, but each student belongs to one House. Many tasks
can pertain to one House, but each task only belongs to one House.
One student can enroll in many courses, and each course can hold many
students. This creates a many-to-many relationship between the tables Student
and Course. To manage this many-to-many relationship, the table Enrolls has
been made to hold the foreign keys, StudentID, and CourseID from their
respective tables.
One subject has many courses, but each course only has one subject. This
creates a one-to-many relationship between the tables Subject and Course. The
Course table holds a foreign key SubjectID to make this happen.
One professor can teach many courses, but each course is taught by only one
professor. This creates a one-to-many relationship between the tables Professor
and Course. The Course table holds the foreign key of the Professor table,
ProfessorID, to create this one-to-many relationship between the two tables.
One course requires many course materials, and a course material can be a part
of many courses. This creates a many-to-many relationship between the tables
Course and Material. This relationship requires the creation of a third table titled
Requires, which holds the CourseID, and MaterialID from their respective
tables.
Each of our tables has a mandatory one or mandatory many relationships
between every table it is related to.

Here is an ER Diagram of the database:
![ER Diagram](https://user-images.githubusercontent.com/104415326/236138948-c4987d35-61fb-4cd9-8e26-9190d35b1cc8.png)

This E-R diagram illustrates the relationships between entities, attributes, and cardinality constraints in the database. 

Here is a Schema Diagram of the database:
![Schema Diagram](https://user-images.githubusercontent.com/104415326/236138960-bc275ee6-3f5f-4c17-b170-57bba8ed12d6.png)

The schema diagram shows a concise view of the relationships between all nine
of the tables. Normalization efforts were not necessary for its creation. All
foreign keys are set to cascade on update and delete; this allows more freedom
in the usability of the database.

Conclusion:

The Hogwarts School of Witchcraft and Wizardry has a plethora of magical and
mysterious elements that require careful organization. Relational databases give
us the ability to undertake such a task. This project required me to learn about
aspects of relational databases such as schema diagrams, entity relationship
diagrams, MySQL Workbench, SQL commands, and Java program creation. By
applying these concepts, we were able to develop a useful database that can
efficiently manage the school's assets. This project also gave me hands-on
experience working on improving programming skills and understanding the
importance of data management. Overall, this project demonstrates how the use
of technology and sophisticated database systems can support even the most
magical organizations.

Use Cases:

- Creating projects that can effectively store and display information through the use of relational databases and SQL queries. 
- Furthering my knowledge of SQL, relational databases, and implementation of relational databases.

Problems:

 - The program doesn't accept multiword names for creating a House. 
 - The program isn't the best implementation of an employee's view from the front end.

Possible Work Arounds:

 - Add a "Consumer" scanner input before taking in a string for the House name. 
 - Spend more time thinking of how an employee would use queries to manage a database for Hogwarts.
 
