Two CSV files are given.
The first file, elev_student.csv, contains: name, subject, and the grade obtained by the student.
The second file, materii.csv, contains the number of credits for each subject.
If the number of credits is 0, then the person is a school student, and in that case, the arithmetic mean should be calculated.
Otherwise, if the number of credits is non-zero, the person is classified as a student, and the weighted arithmetic mean should be calculated using the following formula:
(grade1 * number of credits for subject 1) + (grade2 * number of credits for subject 2) + ... + (gradeN * number of credits for subject N) / number of credits
Write a program that displays in the console the arithmetic mean or weighted arithmetic mean for each person, depending on the case.


Example:
students.csv
Name;Subject;Grade
Pop Alexandru;Geography;10
Popescu Marian;Mathematics;2
Vasilescu Catinca;ASDN;9
Pop Alexandru;Biology;1
Vasilescu Catinca;Philosophy;7
Tomoiaga Ioana;Linear Algebra;3
Miron Costin;Distributed Systems;8
Manea Robert;ASDN;6
Manea Robert;Linear Algebra;8
...

subjects.csv
Name;Credits
Geography;0
Mathematics;0
Linear Algebra;5
ASDN;5
Philosophy;0
Biology;0
Distributed Systems;3
..."
