package org.example.data.mappers;

import org.example.data.entities.BookEntity;
import org.example.data.entities.DrawingBookEntity;
import org.example.data.entities.ItemEntity;
import org.example.data.models.Book;
import org.example.data.models.DrawingBook;
import org.example.data.models.Item;

public class ItemMapper {
    private ItemMapper() {}

    public static Item asItem(ItemEntity entity) {
        return new Item(entity.getId(), entity.getPrice());
    }

    public static Book asBook(ItemEntity itemEntity, BookEntity bookEntity) {
        return new Book(
                itemEntity.id,
                itemEntity.price,
                bookEntity.title,
                bookEntity.author,
                bookEntity.numberOfPages,
                bookEntity.numberOfPagesRead
        );
    }

    public static DrawingBook asDrawingBook(ItemEntity itemEntity, DrawingBookEntity drawingBookEntity) {
        return new DrawingBook(
                itemEntity.id,
                itemEntity.price,
                drawingBookEntity.theme,
                drawingBookEntity.numberOfDrawings,
                drawingBookEntity.numberOfDrawingCompleted
        );
    }
}
