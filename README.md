# Банковская система транзакций

## Описание
Приложение для управления историей банковских транзакций с функциями:
- Добавление новых транзакций
- Отмена последней операции (Undo)
- Повтор отмененной операции (Redo)
- Просмотр полной истории

## Особенности
- Использование `LinkedList` для эффективного Undo/Redo
- Ограничение размера истории
- Логирование времени транзакций
- Обработка ошибок

## Запуск
1. Скомпилируйте проект:
   ```bash
   javac -d bin src/main/java/**/*.java


<img width="574" height="774" alt="image" src="https://github.com/user-attachments/assets/c3184653-fc12-4aa6-9494-9f33fa5c8c07" />
