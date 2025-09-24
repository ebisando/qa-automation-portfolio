const { test, expect } = require('@playwright/test');

test('Checkout flow', async ({ page }) => {
  await page.goto('https://example.com/shop');

  await page.click('text=Add to Cart');
  await page.click('text=Cart');
  await page.click('text=Checkout');

  await page.fill('#name', 'Abby QA');
  await page.fill('#address', '123 QA Street');
  await page.click('text=Submit Order');

  await expect(page.locator('h1')).toHaveText('Order Confirmation');
});
