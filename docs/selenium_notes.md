

## Libraries

```py

import requests
import lxml
from bs4 import BeautifulSoup


import pytest
import time
import json
# import webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.desired_capabilities import DesiredCapabilities
```

```py
# create webdriver object
driver = webdriver.Edge()
```

## Driver Functions


## Element Functions
```py
element.send_keys("some text")
element.send_keys(" and some", Keys.ARROW_DOWN)
element.clear()
```



## Get Webpage
```py
driver.get("https://mingle-portal.inforcloudsuite.com/KINRO_TST?Identity=Mingle")
```

## Elements
```py
## find_element()
### By.ID
driver.find_element(By.ID, "username").send_keys("sromanowski@lci1.com")
driver.find_element(By.ID, "pass").send_keys("Ilovebaseball__2022!!!")
### By.CSS_SELECTOR
driver.find_element(By.CSS_SELECTOR, ".ping-button").click()
### By.NAME
text_box = driver.find_element(by=By.NAME, value="my-text")
### By.XPATH

### By.LINK_TEXT

### By.PARTIAL_LINK_TEXT

### By.TAG_NAME

### 

## find_elements()
### By.TAG_NAME



```

## Select Checkbox
```py
# Locate the checkbox element by its class_Name.  
checkbox = driver.find_element(By.CLASS_NAME, "Automation") 
  
# Click on the checkbox. 
checkbox.click() 
  
# Check if the checkbox is selected. 
if checkbox.is_selected(): 
    print("Checkbox is selected") 

# Find the checkbox element by its class_Name 
checkbox = driver.find_element(By.CLASS_NAME, "Automation") 
  
# Check if the checkbox is enabled 
if checkbox.is_enabled(): 
    # If the checkbox is enabled print a message (Checkbox is selected) 
    print("Checkbox is selected") 
    checkbox.click() 
```

## Select List

```py
import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select


def test_select_options(driver):
    driver.get('https://selenium.dev/selenium/web/formPage.html')

    select_element = driver.find_element(By.NAME, 'selectomatic')
    select = Select(select_element)

    two_element = driver.find_element(By.CSS_SELECTOR, 'option[value=two]')
    four_element = driver.find_element(By.CSS_SELECTOR, 'option[value=four]')
    count_element = driver.find_element(By.CSS_SELECTOR, "option[value='still learning how to count, apparently']")

    select.select_by_visible_text('Four')
    assert four_element.is_selected()

    select.select_by_value('two')
    assert two_element.is_selected()

    select.select_by_index(3)
    assert count_element.is_selected()


def test_select_multiple_options(driver):
    driver.get('https://selenium.dev/selenium/web/formPage.html')
    select_element = driver.find_element(By.NAME, 'multi')
    select = Select(select_element)

    ham_element = driver.find_element(By.CSS_SELECTOR, 'option[value=ham]')
    gravy_element = driver.find_element(By.CSS_SELECTOR, "option[value='onion gravy']")
    egg_element = driver.find_element(By.CSS_SELECTOR, 'option[value=eggs]')
    sausage_element = driver.find_element(By.CSS_SELECTOR, "option[value='sausages']")

    option_elements = select_element.find_elements(By.TAG_NAME, 'option')
    option_list = select.options
    assert option_elements == option_list

    selected_option_list = select.all_selected_options
    expected_selection = [egg_element, sausage_element]
    assert selected_option_list == expected_selection

    select.select_by_value('ham')
    select.select_by_value('onion gravy')
    assert ham_element.is_selected()
    assert gravy_element.is_selected()

    select.deselect_by_value('eggs')
    select.deselect_by_value('sausages')
    assert not egg_element.is_selected()
    assert not sausage_element.is_selected()

def test_disabled_options(driver):
    driver.get('https://selenium.dev/selenium/web/formPage.html')

    select_element = driver.find_element(By.NAME, 'single_disabled')
    select = Select(select_element)

    with pytest.raises(NotImplementedError):
        select.select_by_value('disabled')
```

## Actions
```py
from time import time

from selenium.webdriver import Keys, ActionChains
from selenium.webdriver.common.actions.action_builder import ActionBuilder
from selenium.webdriver.common.by import By


def test_pauses(driver):
    driver.get('https://selenium.dev/selenium/web/mouse_interaction.html')

    start = time()

    clickable = driver.find_element(By.ID, "clickable")
    ActionChains(driver)\
        .move_to_element(clickable)\
        .pause(1)\
        .click_and_hold()\
        .pause(1)\
        .send_keys("abc")\
        .perform()

    duration = time() - start
    assert duration > 2
    assert duration < 3


def test_releases_all(driver):
    driver.get('https://selenium.dev/selenium/web/mouse_interaction.html')

    clickable = driver.find_element(By.ID, "clickable")
    ActionChains(driver)\
        .click_and_hold(clickable)\
        .key_down(Keys.SHIFT)\
        .key_down("a")\
        .perform()

    ActionBuilder(driver).clear_actions()

    ActionChains(driver).key_down('a').perform()

    assert clickable.get_attribute('value')[0] == "A"
    assert clickable.get_attribute('value')[1] == "a"
```



[Writing the results of running unit tests to a file instead of printed to standard output](https://www.geeksforgeeks.org/python-logging-test-output-to-a-file/?ref=ml_lbp)

common technique for running unit tests is to include a small code fragment (as shown in the code given below) at the bottom of your testing file
```PY
import unittest 
class MyTest(unittest.TestCase): 
	... 
if __name__ == '__main__': 
	unittest.main() 

```

This makes the test file executable, and prints the results of running tests to standard output.
To redirect this output, unwind the main() call a bit and write own main() function as shown in the code given below
```PY
import sys 

def main(out = sys.stderr, verbosity = 2): 
	loader = unittest.TestLoader() 

	suite = loader.loadTestsFromModule(sys.modules[__name__]) 
	unittest.TextTestRunner(out, verbosity = verbosity).run(suite) 
	
if __name__ == '__main__': 
	with open('testing.out', 'w') as f: 
		main(f) 

```

## Logging
```py
import logging


def test_logging(log_path):
    logger = logging.getLogger('selenium')

    logger.setLevel(logging.DEBUG)

    handler = logging.FileHandler(log_path)
    logger.addHandler(handler)

    logging.getLogger('selenium.webdriver.remote').setLevel(logging.WARN)
    logging.getLogger('selenium.webdriver.common').setLevel(logging.DEBUG)

    logger.info("this is useful information")
    logger.warning("this is a warning")
    logger.debug("this is detailed debug information")

    with open(log_path, 'r') as fp:
        assert len(fp.readlines()) == 3
```

## File Upload
```py
import os

from selenium import webdriver
from selenium.webdriver.common.by import By


def test_uploads(driver):
    driver.get("https://the-internet.herokuapp.com/upload")
    upload_file = os.path.abspath(
        os.path.join(os.path.dirname(__file__), "..", "selenium-snapshot.png"))

    file_input = driver.find_element(By.CSS_SELECTOR, "input[type='file']")
    file_input.send_keys(upload_file)
    driver.find_element(By.ID, "file-submit").click()

    file_name_element = driver.find_element(By.ID, "uploaded-files")
    file_name = file_name_element.text

    assert file_name == "selenium-snapshot.png"
```