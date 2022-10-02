Feature: Delete book from profile
  As a user, I would like to delete a book from my profile
  Background: User have logged into the application
    Given User "delete" logged in to the application

  @successfully_delete_book_on_profile_page
  Scenario: Delete book on profile page successfully
    Given There is a book named "Git Pocket Guide"
    And User is on profile page
    When The user search book "Git Pocket Guide"
    And The user clicks on Delete icon
    And The user click on OK button
    Then the user clicks on OK button of alert "Book deleted."
    And The book is not shown


