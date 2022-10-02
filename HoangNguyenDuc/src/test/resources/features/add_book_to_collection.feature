Feature: Add book to collection
  As a user, I would like to add a book to my collection
  Background: User have logged into the application
    Given User "add" logged in to the application

  @successfully_add_book_to_collection
  Scenario: Add book to collection successfully
    Given User is on Book Store Page
    When User select a book named "Git Pocket Guide"
    And User click on "Add To Your Collection" add button
    Then an alert "Book added to your collection." is shown
    And Book is shown on user profile

