Feature: Search book on book store page
  As a passer-by user, I would like to search book on book store page

  @search_book_with_multiple_result
  Scenario Outline: Search book on profile page successfully
    Given The user is on Book Store Page
    When User inputs book name
      | bookName   |
      | <bookName> |
    Then all books match with input criteria will be displayed.
    Examples:
      | bookName |
      | Design   |
      | design   |

