CREATE TABLE campaign (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    description VARCHAR(255),
    goal_amount DOUBLE,
    collected_amount DOUBLE DEFAULT 0.0,
    start_date TIMESTAMP,
    end_date TIMESTAMP
);

CREATE TABLE donor (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(255)
);

CREATE TABLE donation (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    amount DOUBLE,
    donation_time TIMESTAMP,
    campaign_id BIGINT,
    donor_id BIGINT,
    CONSTRAINT fk_donation_campaign FOREIGN KEY (campaign_id) REFERENCES campaign(id),
    CONSTRAINT fk_donation_donor FOREIGN KEY (donor_id) REFERENCES donor(id)
);

CREATE TABLE receipt (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    email_sent_to VARCHAR(255),
    sent_date TIMESTAMP,
    donation_id BIGINT UNIQUE,
    CONSTRAINT fk_receipt_donation FOREIGN KEY (donation_id) REFERENCES donation(id)
);

CREATE TABLE audit_log (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    action VARCHAR(255),
    resource VARCHAR(255),
    performed_by VARCHAR(255),
    timestamp TIMESTAMP,
    details TEXT
);
