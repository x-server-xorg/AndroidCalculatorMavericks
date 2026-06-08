# CalcMavericks

Скеоморфный калькулятор в стиле macOS Mavericks для Android.

![Android](https://img.shields.io/badge/Android-8.0%2B-3DDC84) ![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-7F52FF) ![MinSdk](https://img.shields.io/badge/minSdk-26-brightgreen)

## Скриншот

```
┌────────────────────────┐
│  ░░░░░░░░░░░░░░░░░░░░ │  ← LED-дисплей (DSEG7)
│                123456  │
├────┬────┬────┬────────┤
│ AC │ ±  │ %  │   ÷   │  ← светло-серые / оранжевые
├────┼────┼────┼────────┤
│ 7  │ 8  │ 9  │   ×   │
├────┼────┼────┼────────┤
│ 4  │ 5  │ 6  │   −   │
├────┼────┼────┼────────┤
│ 1  │ 2  │ 3  │   +   │
├────┴────┼────┼────────┤
│    0    │ .  │   =   │
└─────────┴────┴────────┘
```

## Особенности

- **Скеоморфный дизайн** — кожаный фон, градиентные кнопки с тенями, LED-дисплей
- **7-сегментный шрифт** DSEG7 Classic для аутентичного вида
- **Адаптация** под телефон и планшет (sw600dp+)
- **Минимальная версия** Android 8.0 (API 26)
- **Без рекламы и разрешений** — ничего лишнего

## Технологии

- **Язык:** Kotlin
- **Сборка:** Gradle 8.11.1 + AGP 8.7.3
- **UI:** XML drawables (layer-list, selector, shape, gradient)
- **Шрифт:** [DSEG7 Classic](https://github.com/keshikan/DSEG) (SIL Open Font License)

## Сборка

```bash
git clone <repo>
cd andr-calc_mavericks
./gradlew assembleDebug
```

APK будет в `app/build/outputs/apk/debug/app-debug.apk`.

## Управление

| Кнопка | Действие |
|--------|----------|
| `AC` / `C` | Сброс всего / сброс ввода |
| `±` | Смена знака |
| `%` | Процент (деление на 100) |
| `+ − × ÷` | Арифметические операции |
| `=` | Результат |
| `0-9 .` | Ввод чисел |

## Структура проекта

```
app/src/main/
├── java/com/calcmavericks/
│   ├── MainActivity.kt          — активити, привязка кнопок
│   └── CalculatorLogic.kt       — логика вычислений
└── res/
    ├── drawable/                — фоны, кнопки, иконка
    ├── font/dseg7.ttf           — 7-сегментный шрифт
    ├── layout/                  — разметка для телефона
    ├── layout-sw600dp/          — разметка для планшета
    └── values/                  — цвета, строки, стили, тема
```
