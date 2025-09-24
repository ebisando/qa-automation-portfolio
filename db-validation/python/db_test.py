import psycopg2

def test_order_status():
    conn = psycopg2.connect(
        dbname="testdb",
        user="testuser",
        password="password",
        host="localhost"
    )
    cur = conn.cursor()
    cur.execute("SELECT status FROM orders WHERE order_id = 101;")
    status = cur.fetchone()[0]

    assert status == "COMPLETED"

    cur.close()
    conn.close()
