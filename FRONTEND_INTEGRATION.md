# How to integrate the sample frontend files

1. Generate Angular project: `ng new mv-frontend --routing --style=scss`
2. Copy everything inside `frontend_sample_src/app` into your `src/` (keep folder structure).
3. Register `AuthInterceptor` in `app.module.ts` providers.
4. Create a route to `ProductListComponent` and render in a page.
5. Start backend first, then `ng serve`.
