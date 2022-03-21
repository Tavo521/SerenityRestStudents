Feature: Rest service of students
  As an administrator of a student list
  I want to perform different actions with this list
  To verify the operation of the service

  Scenario Outline: Create a new student
    Given I have a new student to register with the information <firstName> <lastName> <email> <programme>
    When I create a new student in the list with the information
    Then I verify that it student <firstName> was create successfully

    Examples:
      | firstName | lastName | email             | programme |
      | John      | Doe      | JohnDoe@gmail.com | Systems   |

  Scenario Outline: Update a student
    Given I have a student that needs to update your information <firstName> <lastName> <email> <programme>
    When I update the student information in the list with id <id>
    Then I Verify if the student <firstName> with email <email> was updated

    Examples:
      | firstName | lastName | email           | programme | id |
      | Homero    | Simpson  | homer@gmail.com | Systems   | 1  |

  Scenario Outline: Delete a Student
    When I delete a student in the list with id <id>
    Then I verify that it student with id <id> was delete successfully

    Examples:
      | id |
      | 50 |