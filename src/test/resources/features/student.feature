Feature: Rest service of students
  As an administrator of a student list
  I want to perform different actions with this list
  To verify the operation of the service

  Scenario Outline: Create a new student
    Given I have a new student to register with the information <firstName> <lastName> <email> <programme>
    When I create a new student in the list with the information
    Then I verify that it student <firstName> was create successfully

    Examples:
      | firstName | lastName | email              | programme |
      | John2     | Doe2     | JohnDoe2@gmail.com | Systems   |