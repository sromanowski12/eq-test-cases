### Katalon Studio

#### Variables

**Introduction to Variables**
- In software testing, **variables** refer to the factors that can change or affect the behavior of the software being tested
- Examples of variables in testing include input data, system, configuration, environment settings, user behavior, and so on
- By identifying and managing variables, testers can improve the quality, reliability, and validity of their tests.
- Testers need to be aware of the potential confounding variables that may interfere with their tests and try to minimize their effects
- A good testing strategy should include a clear plan for identifying, controlling, and measuring variables to ensure that the test results are meaningful and actionable

**Different Types of Variables**
- Groovy Variables
  - 
- Test Case Variables
- Global Variables
  - x


**Execution Profiles**




#### Libraries

```groovy
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
```


#### Key Points 

```groovy

```


WebUI.closeBrowser()
#### Statements
##### Decision-Making Statements
If - Else If - Else
```groovy
if (true) { WebUI.click(findTestObject('Page_CuraAppointment/chk_Medicaid'), FailureHandling.STOP_ON_FAILURE) } else if (true) { WebUI.click(findTestObject('Page_CuraAppointment/chk_Medicare'), FailureHandling.STOP_ON_FAILURE) } else { WebUI.click(findTestObject('Page_CuraAppointment/chk_None'), FailureHandling.STOP_ON_FAILURE) }          
```
Switch - Case
```groovy
switch (true) { case true: WebUI.click(findTestObject('Page_CuraAppointment/chk_Medicaid'), FailureHandling.STOP_ON_FAILURE) break case true: WebUI.click(findTestObject('Page_CuraAppointment/chk_Medicare'), FailureHandling.STOP_ON_FAILURE) break default: WebUI.click(findTestObject('Page_CuraAppointment/chk_None'), FailureHandling.STOP_ON_FAILURE) break }        
```

##### Looping Statements
For
```groovy
for (def index : (0..5)) { WebUI.acceptAlert(FailureHandling.STOP_ON_FAILURE) }
```
While
```groovy
while (varA == true) { WebUI.acceptAlert(FailureHandling.STOP_ON_FAILURE) }     
```

##### Branching Statements
Break
```groovy
for (int i = 0; i < max; i++) { // interested only in p's if (searchMe.charAt(i) != 'p') { break; } // process p's numPs++; }       
```
Continue
```groovy
for (int i = 0; i < max; i++) { // interested only in p's if (searchMe.charAt(i) != 'p') { continue; } // process p's numPs++; }
```
Return
```groovy
for (int i = 0; i < max; i++) { // interested only in p's if (searchMe.charAt(i) != 'p') { return true; } // process p's numPs++; }
```

##### Exception Handling Statements

```groovy
   try {
        WebUI.openBrowser('')

        WebUI.navigateToUrl('katalon.com')

        if (WebUI.getText(findTestObject('Object Repository/txt_singin')).length() < 0) {
            throw new com.kms.katalon.core.exception.StepFailedException('Value required')
        }
    }
    catch (StepErrorException e) {
        this.println(e)
    } 
    catch (Exception e) {
        this.println("General issue occurs.")
    } 
    finally { 
        this.println("Navigate to a page.")
    }
```

##### Binary Statement

```groovy
myText = 'Welcome to Katalon Studio'
```
```groovy
myObject = findTestObject('my object') WebUI.setText(myObject, 'Welcome to Katalon Studio') WebUI.verifyTextPresent('Welcome to Katalon Studio', false)
```
##### Method Call Statements

```groovy
WebUiBuiltInKeywords.openBrowser('', FailureHandling.STOP_ON_FAILURE) WebUiBuiltInKeywords.navigateToUrl(GlobalVariable.global_Gmail_Url, FailureHandling.STOP_ON_FAILURE) WebUiBuiltInKeywords.setText(ObjectRepository.findTestObject(null), 'varA'.toString(), FailureHandling.STOP_ON_FAILURE) Integer.notifyAll()
```

##### Assert Statements
##### Define Method

Method declaration
```groovy
Integer myMethod(def param1, def param2) { return param1 + param2 }
```
Method call
```groovy
myVar = myMethod1(varA, varB)
```

#### Call Test Case
```groovy
import com.kms.katalon.core.model.FailureHandling 
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase 
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI 
//Call test case using WebUI Class 
WebUI.callTestCase(findTestCase("Test Case ID"), ["key1":"value1", "key2":"value2", … , "keyN":"valueN"], FailureHandling.OPTIONAL) 
//Call test case using Mobile Class 
Mobile.callTestCase(findTestCase("Test Case ID"), ["key1":"value1", "key2":"value2", … , "keyN":"valueN"], FailureHandling.OPTIONAL)
```

#### Test Listeners
Test Listener Template
```groovy
import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class NewTestListener {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def sampleBeforeTestCase(TestCaseContext testCaseContext) {
		println testCaseContext.getTestCaseId()
		println testCaseContext.getTestCaseVariables()
	}

	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
		println testCaseContext.getTestCaseId()
		println testCaseContext.getTestCaseStatus()
	}

	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
		println testSuiteContext.getTestSuiteId()
	}
	/**
	 * Executes after every test suite ends.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@AfterTestSuite
	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {
		println testSuiteContext.getTestSuiteId()
	}
}
```

 change the environment variable to your preferred environment by following the script below:
```groovy
import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

/**
 * Executes before every test case starts.
 * @param testCaseContext related information of the executed test case.
 */

@BeforeTestCase
def sampleBeforeTestCase(TestCaseContext testCaseContext) {
    if (GlobalVariable.gl_Environment == 'Local') {
        GlobalVariable.gl_Url = 'localhost'
    } else if (GlobalVariable.gl_Environment == 'Staging') {
        GlobalVariable.gl_Url = 'staging'
    }
}
```


#### Examples

##### Example 1 - Navigating to a URL and Verifying the Page Title

```groovy
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Open a browser and navigate to a URL
WebUI.openBrowser('https://www.example.com')

// Wait for the page to fully load
WebUI.waitForPageLoad(10)

// Verify the page title
boolean titleIsCorrect = WebUI.verifyTitle('Expected Page Title', false)

println("Is the page title correct? : " + titleIsCorrect)

// Close the browser
WebUI.closeBrowser()
```

##### Example 2 - Inputting Text into a Text Box and Clicking a Button

```groovy
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

// Open a browser and navigate
WebUI.openBrowser('https://www.example.com/login')

// Input username
WebUI.setText(findTestObject('input_Username'), 'testUser')

// Input password
WebUI.setEncryptedText(findTestObject('input_Password'), 'encryptedPassword')

// Click the login button
WebUI.click(findTestObject('btn_Login'))

// Optionally, add a wait here to ensure the next page or a specific element is loaded
WebUI.waitForElementVisible(findTestObject('dashboard/Main'), 10)

// Close the browser
WebUI.closeBrowser()
```

##### Example 3 - Handling Dropdowns, Checkboxes, and Radio Buttons

```groovy
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

WebUI.openBrowser('https://www.example.com/settings')

// Select an option from a dropdown by value
WebUI.selectOptionByValue(findTestObject('select_Theme'), 'darkMode', false)

// Check a checkbox (only if it's not already checked)
if (!WebUI.verifyElementChecked(findTestObject('checkbox_EnableNotifications'), 5)) {
    WebUI.click(findTestObject('checkbox_EnableNotifications'))
}

// Select a radio button
WebUI.click(findTestObject('radio_LanguageEnglish'))

// Wait for an element to confirm the action, e.g., a success message
WebUI.waitForElementVisible(findTestObject('text_SuccessMessage'), 10)

WebUI.closeBrowser()
```

##### Example 4 - Asserting Element Text and Taking a Screenshot

```groovy
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

WebUI.openBrowser('https://www.example.com/settings')

// Select an option from a dropdown by value
WebUI.selectOptionByValue(findTestObject('select_Theme'), 'darkMode', false)

// Check a checkbox (only if it's not already checked)
if (!WebUI.verifyElementChecked(findTestObject('checkbox_EnableNotifications'), 5)) {
    WebUI.click(findTestObject('checkbox_EnableNotifications'))
}

// Select a radio button
WebUI.click(findTestObject('radio_LanguageEnglish'))

// Wait for an element to confirm the action, e.g., a success message
WebUI.waitForElementVisible(findTestObject('text_SuccessMessage'), 10)
```