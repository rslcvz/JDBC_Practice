@Test1
Feature: User Get Spartan Data

#  Scenario: Authenticated User Should be able to Get Spartan Data
#    Given Credentials with USER_role is provided
#    When user try to send get request on "/spartans/10"
#    Then user should get status code 200

    @Test2
    Scenario: User should be able to get Spartan data
      Given User should be able to choose the content type
      When user need to send get request on "/spartans/10"
      Then user should be able get status code 200

