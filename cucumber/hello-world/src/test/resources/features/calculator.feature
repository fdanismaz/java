Feature: x + y = z
  Sum feature works sums two arguments and returns their sum

  Scenario Outline: Sum two numbers
    Given X is <x>
    And Y is <y>
    When I ask their sum
    Then I should be told as <answer>
    Examples:
      | x | y | answer |
      | 2 | 3 | 5 |
      | 4 | 5 | 9 |