import { test, expect } from '@playwright/test';

test('Google search test', async ({ page }) => {
  await page.goto('https://www.google.com');
  await page.fill('textarea[name="q"]', 'Playwright');
  await page.keyboard.press('Enter');
  await expect(page).toHaveURL(/search/);
});