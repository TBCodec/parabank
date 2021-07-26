# parabank

## Story

You are a bank clerks and you need to manage one of your customer's private bank account at [ParaBank](https://parabank.parasoft.com/).

## What are you going to learn?

- getting faimiliar with Page Object Model (POM)
- how to locate objects in the browser
- some good practices with POM
- getting familiar with how does a complex Selenium test scenario works with Page Object Model

## Tasks

1. Create an account at `https://parabank.parasoft.com/`.
    - Have a ParaBank account.

2. Make a successful login to ParaBank.
    - Registered ParaBank account is needed.
    - Login succesful.

3. Check that the Total Balance amount on the AccountsOverView Page is equal to the expected.
    - Registered ParaBank account (and also an account to the is also needed, but you can get one by default when you register) is needed.
    - Test passes, the amount of the Total Balance is equal to the expected.

4. Open a new Account and check if it's successfully created.
    - Registered ParaBank account is needed.
    - Test passes, the new Account has been created.

5. Pay bills for stub account.
    - Need at least two accounts.
    - Test passes, the bill pay was successful, and the account's balance which did the payment has decreased with the amount value.

6. Search for a transaction by getting it's ID from the Accounts Overview page (by clicking on the transaction link and navigating to the transaction details page). Check if the transaction details are the same on the search result page and on the accounts overview page.
    - Need at least one existing transaction, so search can be available for it.
    - Test passes, and the transaction details data are equal on the search result page and on the accounts overview page.

7. Transfer some amount of money from an existing account to another one.
    - Need at least two accounts.
    - Test passes, the amount of money has been transferred from the source account to the destination account.

8. Request loan from an account.
    - Existing account which can be chosen for loan.
    - Test passes, the loan was successful, so the amount of the 'loan account' has been changed.

9. Update the phone number contact information.
    - Registered ParaBank account is needed.
    - Test passes, the phone number has been updated to the new value.

## General requirements

None

## Hints

- Extract your multiple times used code into private methods, so you can avoid code duplications
- Always keep your webdriver, and the UI synchronized (aka. use waits everywhere where they are justified)

## Background materials

- <i class="far fa-exclamation"></i> [Selenium Browser Manipulation](project/curriculum/materials/competencies/selenium-basics/selenium-browser-manipulation.md.html)
- <i class="far fa-exclamation"></i> [Selenium Locators](project/curriculum/materials/competencies/selenium-basics/selenium-locators.md.html)
- <i class="far fa-exclamation"></i> [Selenium Waits and Alerts](project/curriculum/materials/competencies/selenium-basics/selenium-waits-and-alerts.md.html)
