# Kampala Street Vendor Management System (KSVMS)
### Object-Oriented Programming Assignment Group 6
**Cavendish University Uganda**

---

## Table of Contents

- [Project Overview](#project-overview)
- [Background](#background)
- [System Features](#system-features)
- [OOP Principles Applied](#oop-principles-applied)
- [System Requirements](#system-requirements)
- [Class Structure](#class-structure)
- [How to Run](#how-to-run)
- [Project Structure](#project-structure)
- [Group Members](#group-members)
- [References](#references)

---

## Project Overview

The **Kampala Street Vendor Management System (KSVMS)** is a Java-based desktop application built as part of the Object-Oriented Programming course at Cavendish University Uganda. The system proposes a software solution to the ongoing street vendor crisis in Kampala's Central Business District (CBD), enabling transparent vendor registration, market space allocation, KCCA officer management, and grievance tracking — all under one digital platform.

> *"The Kampala vendor problem is not behavioural, it is structural."*
> Mukwaya et al. (2025)

---

## Background

Kampala has long been defined by street vendors occupying sidewalks, roadways, and building verandas. In **February 2026**, the Government of Uganda issued a two-week ultimatum ordering all street vendors to vacate public spaces. When the deadline expired on **19th February 2026**, KCCA officers and Uganda Police conducted enforcement operations clearing the CBD.

Despite KCCA operating **17 public markets** and **over 50 private markets** with capacity for 30,000+ traders, stalls remained vacant — vendors preferred high-footfall street locations. This system addresses the core gap: **no single, transparent digital platform existed to match vendors to available spaces**.

---

## System Features

### Functional Features
| Module | Key Capabilities |
|--------|-----------------|
| **Vendor Management** | Registration, licence auto-generation, profile display, status updates |
| **Market Space Management** | Space registration, real-time availability tracking, smart vendor-space matching |
| **KCCA Authority Management** | Officer registration, role-based access control, officer-led relocations |
| **Grievance & Feedback** | Grievance submission, unique ID tracking, status progression, reporting |
| **Reporting & Analytics** | Occupancy reports, compliance summaries, unmatched vendor lists |

---

## OOP Principles Applied

| Principle | How It Is Used |
|-----------|---------------|
| **Encapsulation** | All vendor and market data stored in `private` fields; accessed only through validated getters and setters |
| **Inheritance** | `Vendor` and `KCCAOfficial` both extend the abstract `CustomUser` base class |
| **Polymorphism** | `displayProfile()` behaves differently for a Vendor, Inspector, and Administrator — same method name, different output |
| **Abstraction** | `CustomUser` defines abstract methods (`register()`, `getStatus()`, `displayProfile()`) enforced across all subclasses |

---

## System Requirements

### Functional Requirements (Summary)

| ID | Requirement |
|----|-------------|
| FR-1 | Vendor registration with auto-generated Vendor ID |
| FR-2 | Licence generation in format `KCCA-[VendorID]-[YEAR]` |
| FR-3 | Vendor personal data capture (gender, DOB, residence) |
| FR-4 | Vendor status management (ACTIVE / SUSPENDED / PENDING) |
| FR-5 | Market stall allocation to registered vendors |
| FR-6 | Vendor search by name, ID, type, or market |
| FR-7 | Market management with unique space IDs |
| FR-8 | Real-time space availability tracking |
| FR-9 | KCCA officer registration and role assignment |
| FR-10 | Role-based profile display and access control |
| FR-11 | Grievance submission by registered vendors |
| FR-12 | Grievance ID assignment and status tracking |
| FR-13 | Grievance summary reporting by type |

### Non-Functional Requirements (Summary)

| ID | Quality Attribute | Target |
|----|------------------|--------|
| NFR-1 | **Performance** | Core operations complete in < 5 seconds (Intel i5, 8GB RAM) |
| NFR-2 | **Throughput** | Supports simultaneous multi-user data operations |
| NFR-3 | **Usability** | Intuitive dashboard navigation for all user types |
| NFR-4 | **Error Handling** | Clear, actionable error messages on invalid input |
| NFR-5 | **Authentication** | Email + password login required for all operations |
| NFR-6 | **Role-Based Access** | Vendors see vendor screens; Admins see admin functions |

---

## Class Structure

```
CustomUser (abstract)
├── Vendor
│   ├── vendorType
│   ├── capitalAmount
│   ├── assignedMarket
│   └── licenceNumber
│
└── KCCAOfficial
    ├── role (Inspector / Administrator)
    └── assignedZone

MarketSpace
├── spaceID
├── marketName
├── monthlyRent
├── isOccupied
└── assignedVendorId

GrievanceReport
├── grievanceID
├── vendorID
├── type
├── status (OPEN / UNDER_REVIEW / RESOLVED)
└── dateSubmitted

VendorManagementSystem  ← Main Controller
├── List<Vendor>
├── List<MarketSpace>
├── List<KCCAOfficial>
├── registerAllVendors()
├── findAvailableSpace()
├── displayAllProfiles()
└── generateReport()
```

---

## How to Run

### Prerequisites
- Java JDK 11 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code with Java Extension)

### Steps

1. **Clone or download** the project repository.

2. **Open** the project in your Java IDE.

3. **Compile** all `.java` files:
   ```bash
   javac src/*.java
   ```

4. **Run** the main entry point:
   ```bash
   java Main
   ```

5. **Expected output** — the system will:
   - Register sample vendors and market spaces
   - Automatically match vendors to affordable spaces
   - Display all vendor and officer profiles
   - Print a market occupancy report

### Sample Run Output
```
Officer Nuweabine Daniel registered as Inspector
Vendor Sarah Naggayi registered. Licence: KCCA-V001-2026
Vendor Joseph Bazaire registered. Licence: KCCA-V002-2026
Space US-12 assigned to Sarah Naggayi

===== ALL REGISTERED ENTITIES =====
--- VENDOR PROFILE ---
Name: Sarah Naggayi
Type: Food
Capital: UGX 50000.0
Market: Usafi Market, Stall 12
Status: ACTIVE

Total Vendors: 3
Market Spaces Occupied: 1
Market Spaces Available: 2
```

---

## Project Structure

```
KSVMS/
│
├── src/
│   ├── CustomUser.java          # Abstract base class
│   ├── Vendor.java              # Vendor entity
│   ├── KCCAOfficial.java        # KCCA officer entity
│   ├── MarketSpace.java         # Market stall entity
│   ├── GrievanceReport.java     # Grievance tracking
│   ├── VendorManagementSystem.java  # Main system controller
│   └── Main.java                # Program entry point
│
├── docs/
│   ├── SSVMS_Assignment.docx    # Full assignment report
│   ├── SSVMS_Literature_Addendum.docx  # Academic literature review
│   └── SSVMS_System_Requirements.docx  # System requirements specification
│
└── README.md
```

---

## Group Members

| # | Name                       | Student ID |
|---|----------------------------|------------|
| 1 | *(Lukwago Joseph Bakumpe)* | 258278     |
| 2 | *(Member 2)* | |
| 3 | *(Member 3)* | |
| 4 | *(Member 4)* | |
| 5 | *(Member 5)* | |


---

## References

1. Mukwaya, P. I., Mbabazi, J., & Ernstson, H. (2025). *Kampala City Report.* ACRC Working Paper, University of Manchester.

2. Hoelscher, K., Ainembabazi, T., Mbabazi, J., Mukwaya, P., & Rolandsen, Ø. H. (2025). "Peace is when we are working": Insecurity and small business survival in Kampala. *Business Horizons, 68*(4), 525–539.

3. Twinomujuni, R. *Strategic Planning and Business Growth of Companies Operating in Uganda: A Case of Kampala City Council Authority.* Metropolitan International Journals.

4. Whitesell, D., Faria, C., Boonabaana, B., Ankunda, J. B., Katushabe, J., & Tumuhaise, P. (2025). Designing a 'vibrant, attractive and sustainable city': feminist approaches to beautification in Kampala, Uganda. *Gender, Place & Culture, 32*(6), 826–847.

5. Economic Policy Research Centre (EPRC). *City Authorities Can Engage Vendors Without Brutality.*

6. Nile Post. (February 2026). *Kampala Streets Empty as Authorities Begin Vendor Evictions.*

7. Daily Monitor. (February 2026). *Showdown Looms in Kampala as Street Vendors Vow to Defy KCCA.*

8. NTV Uganda. (2026). *KCCA Unveils Plans to Evict Street Vendors.* https://ntv.co.ug/news/kcca-unveils-plans-to-evict-street-vendors

---