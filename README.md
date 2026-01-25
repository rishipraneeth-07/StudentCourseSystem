# Student Course Management System (Spring Boot)

## Features

### Student Management

- Create, update, view, and delete students

- Attach student profile (address, phone, gender)

### Course Management

- Create, update, view, and delete courses

- Each course has code, credits, and duration

### Enrollment Management

- Enroll students into courses

- Prevent duplicate enrollments

 - - View:

 - All courses of a student

 - All students of a course

 - Remove enrollment (unenroll)

### Admin Mode (Without Spring Security)

- Admin-only endpoints under /admin/**

- Access controlled using request header

## Testing Using Postman

## Students CRUD Operations

### POST (4 students)

<img width="1913" height="977" alt="Screenshot 2026-01-24 113303" src="https://github.com/user-attachments/assets/b0fcdb41-8033-4d81-ae4a-1e27d5e0a9cc" />

### GET Student-1

<img width="1915" height="967" alt="Screenshot 2026-01-24 113512" src="https://github.com/user-attachments/assets/8265677f-560d-4718-969e-3a60ca581710" />

### GET Student-2

<img width="1911" height="1028" alt="Screenshot 2026-01-24 113542" src="https://github.com/user-attachments/assets/ef4c9c20-a9f7-4185-aa99-4a4815bacea9" />

### PUT (student 1 updated)

<img width="1923" height="969" alt="Screenshot 2026-01-24 113642" src="https://github.com/user-attachments/assets/c6efde84-1c24-4476-a9b9-8a1e1768c0f0" />

### DELETE (student-2)

<img width="1921" height="812" alt="Screenshot 2026-01-24 113714" src="https://github.com/user-attachments/assets/67476cc8-b773-4f49-aa74-338da307a1eb" />

### Attached StudentProfile to Student by id

<img width="1922" height="1110" alt="Screenshot 2026-01-24 121752" src="https://github.com/user-attachments/assets/8c55f797-d6e9-493f-a7dd-1cd408a1d8b8" />


## Courses

### POST (2 courses)  
<img width="1923" height="972" alt="Screenshot 2026-01-24 113818" src="https://github.com/user-attachments/assets/92a589cc-c3a5-4581-bc29-6ef97957e98c" />

### GET (Course by ID)
<img width="1915" height="981" alt="Screenshot 2026-01-24 115233" src="https://github.com/user-attachments/assets/25acd42a-e485-4328-8f66-5f99ff232a04" />

## Enrollments

### POST (studentId &courseId)

<img width="1918" height="1310" alt="Screenshot 2026-01-25 112524" src="https://github.com/user-attachments/assets/07eb1dbb-2a86-4a3e-b5b9-b210af234d8a" />

### GET (Get All Courses of Student)

<img width="1918" height="1025" alt="Screenshot 2026-01-25 112614" src="https://github.com/user-attachments/assets/b66ac89e-3ffd-4aa7-9e0e-defb469e4971" />

### GET (Get All Students of Course)

   
<img width="1919" height="1038" alt="Screenshot 2026-01-25 112645" src="https://github.com/user-attachments/assets/7071d904-efc9-420b-a3ca-45fe92c63237" />

### DELETE 

<img width="1913" height="816" alt="Screenshot 2026-01-25 112721" src="https://github.com/user-attachments/assets/07dd1928-3e4f-4665-935e-b9014c77dc66" />






