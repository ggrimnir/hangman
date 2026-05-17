# Виселица (Hangman) - консольная игра на Java

Консольная реализация классической игры «Виселица» на Java. Игроку необходимо угадать загаданное слово по буквам. 
Каждая ошибка приближает «виселицу», которая отрисовывается ASCII-графикой

## Правила игры

1. Компьютер загадывает случайное слово (существительное в именительном падеже, > 5 букв);
2. Игрок называет буквы по одной;
3. Если буква есть в слове - она открывается на своих позициях;
4. Если буквы нет - засчитывается ошибка, дорисовывается часть виселицы;
5. Цель - угадать слово до того, как количество ошибок достигнет максимума;
6. После победы или поражения можно сыграть снова или выйти.

## Функционал

- Случайный выбор слова из словаря (файл `src/resouces/dictionary.txt`)
- Отображение текущего состояния слова (угаданные буквы и ошибки)
- Счётчик ошибок и пошаговая отрисовка виселицы
- Завершение игры с объявлением результата
- Возможность начать новую игру или выйти

## Технологии

- **Java** 
- Только стандартная библиотека 
- Работа с файлами для чтения словаря

## Структура проекта - ООП-подход
- hangman/
  - App.java
  - controller/
    - GameProcess.java
  - exception/
    - ConsoleLetterRequestInputException.java
    - ConsoleMenuInputException.java
    - DictionaryEmptyException.java
    - GameLetterInvalidException.java
    - GameLetterAlreadyUsedException.java
  - model/
    - Game.java
    - GameStatus.java
    - MaskHandler.java
    - Word.java
  - util/
    - Chooser.java
    - DictionaryChooser.java
  - view/
    - Console.java
    - HangmanAsciiArt.java
  - resources/
    - dictionary.txt
