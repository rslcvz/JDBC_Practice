@Mustafa
Feature:
  Scenario Outline:  User should be able to send get request to Spartans page
    Given User has the required end point and access token
    When User sends a get request to the <"end point">
    Then User should get <"status code"> status code
    And Content type should be in <"Content Type"> format

      Examples:
    |status code|end point       |Content Type    |
    |200        |spartan.base_url|ContentType.JSON|
#    |401        |spartan.base_url|ContentType.XML |
#    |403        |spartan.base_url|ContentType.XML |



