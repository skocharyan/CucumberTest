Feature: Login Pge Test
  Scenario: Login Page Test
    Given on login page
    When fill in use name "socharyan1993@gmail.com" and password "myangeltest" and click Sign in
    Then validate cabinet name wih "skoch"
