Feature: Rest service of students
  As an administrator of a student list
  I want to perform different actions with this list
  To verify the operation of the service

  Scenario Outline: Create a new student
    Given I have a new student with the information <firstName> <lastName> <email> <programme> <course>
    When I create a new student with the information
    Then I verify that it student was create successfully

    Examples:
      | firstName | lastName | email             | programme | course |
      | John      | Doe      | JohnDoe@gmail.com | Systems   | Java   |