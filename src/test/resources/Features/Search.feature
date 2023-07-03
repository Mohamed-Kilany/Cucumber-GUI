Feature: Search Google with a SearchTerm

  Scenario Outline:
    Given User navigates to <SearchEngine> homepage
    When User enters a search term of <SearchTerm> and hits Enter
    Then Search results cards should contain <ResultTerm> confirming relevancy

    Examples:
      | SearchEngine | SearchTerm  | ResultTerm |
      | Google       | TestCrew    | Test       |
      | Google       | CucumberBDD | BDD        |
      | Bing         | TestCrew    | Test       |