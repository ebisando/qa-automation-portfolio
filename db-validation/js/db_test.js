const { Client } = require('pg');

test('Check order status', async () => {
  const client = new Client({
    user: 'testuser',
    host: 'localhost',
    database: 'testdb',
    password: 'password',
    port: 5432,
  });

  await client.connect();
  const res = await client.query('SELECT status FROM orders WHERE order_id = 101;');
  expect(res.rows[0].status).toBe('COMPLETED');
  await client.end();
});
