-- Campaigns
INSERT INTO campaign (id, title, description, goal_amount, collected_amount, start_date, end_date)
VALUES
(1, 'Save the Forests', 'Help us plant 10,000 trees.', 10000.0, 0.0, '2024-01-01T00:00:00', '2024-12-31T23:59:59');

-- Donors
INSERT INTO donor (id, full_name, email, phone)
VALUES
(1, 'Alice Smith', 'alice@example.com', '1234567890'),
(2, 'Bob Johnson', 'bob@example.com', '0987654321');

-- Donations
INSERT INTO donation (id, amount, donation_time, campaign_id, donor_id)
VALUES
(1, 200.0, '2024-05-01T10:00:00', 1, 1),
(2, 150.0, '2024-05-02T14:30:00', 1, 2);

-- Receipts
INSERT INTO receipt (id, email_sent_to, sent_date, donation_id)
VALUES
(1, 'alice@example.com', '2024-05-01T12:00:00', 1),
(2, 'bob@example.com', '2024-05-02T16:00:00', 2);

-- Audit Logs
INSERT INTO audit_log (id, action, resource, performed_by, timestamp, details)
VALUES
(1, 'CREATE', 'Campaign', 'admin', '2024-05-01T09:00:00', 'Created Save the Forests campaign'),
(2, 'DONATION', 'Donation', 'alice@example.com', '2024-05-01T10:00:00', 'Donated $200 to campaign Save the Forests');
