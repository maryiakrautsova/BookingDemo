Feature: Search hotel

  Scenario: Search for hotel and check its rating
    Given Main Booking page is opened
    When User inputs "Destination/property name:"
    And Clicks "Search"
    Then "Filitheyo Island Resort" hotel is present on the search result list.
    Then "8.7" rating is present.
    #Filitheyo Island Resort