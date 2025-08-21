# Multi-Vendor E-Commerce Platform (Starter)

This is a **starter** project to help you meet your marking scheme quickly.

## Tech
- Backend: Spring Boot 3, JPA, Security (HTTP Basic), MySQL
- Frontend: Angular (standalone components), HttpClient
- Auth: Basic Auth with DB users & roles (seeded)
- Payments: Stub (extend with Stripe/Razorpay)

## How to Run
### Backend
1. Install JDK 17+ and Maven.
2. Start MySQL and set user/pass in `backend/src/main/resources/application.properties`.
3. In `backend/` run:
```bash
mvn spring-boot:run
```

### Frontend
1. Install Node.js 18+.
2. In `frontend/` run:
```bash
npm install
npm start
```
Open http://localhost:4200

### Test Accounts
- Admin: `admin / admin123`
- Vendor: `vendor1 / vendor123`
- Customer: `user1 / user123`



