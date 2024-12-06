**سوال دوم**

در این بخش از پروژه، هدف این است که یک قطعه کد به زبان جاوا که از الگوریتم brute-force برای پیدا کردن نزدیک‌ترین جفت نقاط استفاده می‌کند را بهینه‌سازی کنیم. ابتدا با استفاده از ابزار **Yourkit**، عملکرد کد را پروفایل می‌کنیم تا بخش‌هایی از کد که بیشترین مصرف منابع (CPU و حافظه) را دارند شناسایی کنیم. سپس، کد را به گونه‌ای تغییر می‌دهیم که مصرف منابع نسبت به نسخه‌ی قبلی کاهش یابد.

کدی که در این بخش استفاده شده است، یک مجموعه از نقاط تصادفی را تولید می‌کند و سپس از الگوریتم brute-force برای محاسبه‌ی نزدیک‌ترین جفت نقاط در میان آنها استفاده می‌کند. در این الگوریتم، همه‌ی جفت‌های ممکن از نقاط بررسی می‌شوند و فاصله‌ی آنها محاسبه می‌شود تا نزدیک‌ترین جفت شناسایی شود. این روش با پیچیدگی زمانی **O(n²)** است که به‌ویژه برای مجموعه‌های داده‌ی بزرگ (مثل 100000 نقطه در این مثال) زمان و منابع زیادی مصرف می‌کند. تعداد نقاط در ورودی دریافت می‌شود.

در مرحله‌ی بعد، این کد بهینه‌سازی می‌شود تا مصرف منابع کاهش یابد و عملکرد بهتری در داده‌های بزرگتر داشته باشد. این کار از طریق استفاده از الگوریتم‌های بهینه‌تر مانند **Divide and Conquer** برای پیدا کردن نزدیک‌ترین جفت نقاط انجام می‌شود. با پیاده سازی کد به این روش پیچیدگی زمانی به خوبی کاهش می‌یابد.

در ادامه نتایج اجرای پروفایلینگ برای کد قبلا از بهینه کردن آن را مشاهده میکنیم. در این نتایج تابع findClosestPair همانطور که مشاهده می‌شود بیشترین تاثیر را در استفاده ار منابع دارد:

![image](https://github.com/user-attachments/assets/af51df3f-2877-4167-ae7a-5604fb1b75c4)


![image](https://github.com/user-attachments/assets/d7350b91-4a34-48fc-bda8-6d6e70eab4c3)


![image](https://github.com/user-attachments/assets/c8a03b71-b9b1-4ad0-bbdb-67c8bbed674a)



با استفاده از الگوریتم divide and conquer همانطور که در کد ClosestPairOpt در فولد section2 مشاهده میکنید سعی میکنیم فرایند پیدا کردن نزدیک ترین نقاط و تابع closestPair را بهینه کنیم و پس از انجام پروفالینگ به نتایج زیر می‌رسیم و مدت زمان استفاده از cpu همانطور که در عکس‌ها آمده است کاهش یافته است:

<img width="1293" alt="Screen Shot 2024-12-06 at 10 26 41 PM" src="https://github.com/user-attachments/assets/6ff54e61-f360-42e6-ab18-57daa5e5d7a4">

<img width="1329" alt="Screen Shot 2024-12-06 at 10 34 05 PM" src="https://github.com/user-attachments/assets/fd3bdc8c-1666-4c19-9457-5d56107aa160">



<img width="1292" alt="Screen Shot 2024-12-06 at 10 28 21 PM" src="https://github.com/user-attachments/assets/5cb9e6a2-0a7a-4424-be9c-0d34ac7983b0">
