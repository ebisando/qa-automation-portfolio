// example.spec.js
import { test, expect } from '@playwright/test';

test('Google search test', async ({ page }) => {
  // 1️구글 페이지로 이동
  await page.goto('https://www.google.com');

  // 2️검색창에 "Playwright" 입력
  await page.getByRole('combobox', { name: /search/i }).fill('Playwright');

  // 3️엔터 누르기
  await page.keyboard.press('Enter');

  // 4️결과에 "playwright.dev" 링크가 있는지 확인
  await expect(page).toHaveURL(/search/);
  await expect(page.getByText('playwright.dev')).toBeVisible();
});
