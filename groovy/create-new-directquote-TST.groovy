import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://mingle-portal.inforcloudsuite.com/KINRO_TST?Identity=Mingle')

WebUI.setText(findTestObject('KINRO_TST v2/Page_Infor CloudIdentities - Sign In/input_Username_username'), 'sromanowski@lci1.com')

WebUI.setEncryptedText(findTestObject('KINRO_TST v2/Page_Infor CloudIdentities - Sign In/input_Password_pass'), 'VCJAGvRPL32rAH9ErxswkbUpa0/gezy0')

WebUI.sendKeys(findTestObject('KINRO_TST v2/Page_Infor CloudIdentities - Sign In/input_Password_pass'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/KINRO_TST v2/Page_Enterprise Quoting/span_New Quote_v2'))

WebUI.click(findTestObject('KINRO_TST v2/Page_Enterprise Quoting/span_Select Customer_IC OF OK'))

WebUI.click(findTestObject('KINRO_TST v2/Page_Enterprise Quoting/span_Select'))

WebUI.click(findTestObject('KINRO_TST v2/Page_Enterprise Quoting/span_Add Items'))

WebUI.click(findTestObject('KINRO_TST v2/Page_Enterprise Quoting/Product_677127'))

WebUI.click(findTestObject('Object Repository/KINRO_TST v2/Page_Enterprise Quoting/Quote Hyperlink'))

WebUI.click(findTestObject('Object Repository/KINRO_TST v2/Page_Enterprise Quoting/a_Send Specs'))

WebUI.click(findTestObject('KINRO_TST v2/Page_Enterprise Quoting/button_Yes'))

WebUI.closeBrowser()

