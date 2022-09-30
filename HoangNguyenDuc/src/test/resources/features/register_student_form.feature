Feature: Register student form
  As a passer-by user, I would like to fill in register student form

  @successfully_register_student
  Scenario Outline: Register student successfully
    Given User is in register student page
    When the user input information below to all fields to register form
      | firstName   | lastName   | email   | gender   | mobile   | dateOfBirth   | subjects   | hobby   | picture   | currentAddress   | state   | city   |
      | <firstName> | <lastName> | <email> | <gender> | <mobile> | <dateOfBirth> | <subjects> | <hobby> | <picture> | <currentAddress> | <state> | <city> |
    And the user click on submit button
    Then a successful message "Thanks for submitting the form" is shown
    And a form appear show the input information
    Examples:
      | firstName | lastName | email       | gender | mobile     | dateOfBirth     | subjects       | hobby  | picture           | currentAddress | state | city  |
      | Hoang     | Nguyen   | h@gmail.com | Male   | 1234567890 | 17 January 2022 | Maths, English | Sports | image_student.png | Address demo1  | NCR   | Delhi |
      | Hoang     | Nguyen   |             | Male   | 1234567890 |                 |                |        |                   |                |       |       |
