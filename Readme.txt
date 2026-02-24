           ┌────────────────────┐
           │    Bootstrap       │  (Spring)
           └─────────┬──────────┘
                     │
           ┌─────────▼──────────┐
           │   Application      │  (Use Cases)
           └─────────┬──────────┘
                     │
           ┌─────────▼──────────┐
           │      Domain        │  (Business rules)
           └─────────▲──────────┘
                     │
           ┌─────────┴──────────┐
           │  Infrastructure    │  (Adapters)
           └────────────────────┘

Les flèches représentent les dépendances compile-time.