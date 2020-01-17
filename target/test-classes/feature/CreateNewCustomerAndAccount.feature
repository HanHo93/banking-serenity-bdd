Feature: Create new customer and account

  Scenario: Verify new customer and account, deposit can be added
    Given User logs in successfully with username "mngr241881" and password "jUbYmYb"
    When User clicks on add new customer
    Then Input all fields of create customer form and verify new customer is created successfully
      |Customer Name|Gender   |Date of Birth| Address| City     |State|PIN    |Mobile Number|Password |
      |Han Ho       |f        |02/01/1993   |285 CMT8|Ho Chi Minh|NA  |700000 |0988928881   |123456789|

    When User clicks on add new account
    And Input all fields of new account form and verify account is created successfully
      |Customer Id|Customer Name |Email  |Account Type   |Date of Opening|Initial Deposit|
      |           |              |       |Current      |                 |   10000000   |
    And User clicks on deposit
    Then Input data to deposit form and verify the deposit function works correctly
      |Account Id|Amount Credited   |Description     | Type of Transaction |Current Balance|
      |           |500000           |Test test       | Deposit             |               |