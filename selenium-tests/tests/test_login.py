import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys

@pytest.fixture
def driver():
    driver = webdriver.Chrome()
    driver.get("https://example.com/login")
    yield driver
    driver.quit()

def test_login_valid_user(driver):
    driver.find_element(By.ID, "username").send_keys("testuser")
    driver.find_element(By.ID, "password").send_keys("password123")
    driver.find_element(By.ID, "loginBtn").click()

    assert "Dashboard" in driver.page_source
# test