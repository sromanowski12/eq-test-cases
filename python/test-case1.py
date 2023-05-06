from selenium import webdriver
from selenium.webdriver.common.by import By
import time

driver = webdriver.Edge()

driver.get('https://mingle-portal.inforcloudsuite.com/KINRO_TST?Identity=Mingle')

element = driver.find_element(By.ID, 'username')
element.send_keys('sromanowski@lci1.com')

element2 = driver.find_element(By.NAME, 'pass')
element2.send_keys('Ilovebaseball__2022!!!')

element3 = driver.find_element(By.CSS_SELECTOR, '.ping-button')
element3.click()

time.sleep(5)
driver.quit()
