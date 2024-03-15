package org.example.data.mappers;

import org.example.data.entities.BookEntity;
import org.example.data.entities.ItemEntity;
import org.example.data.models.Book;
import org.example.data.models.ColoringBook;
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

    public static ColoringBook asDrawingBook(ItemEntity itemEntity, org.example.data.entities.ColoringBook coloringBookEntity) {
        return new ColoringBook(
                itemEntity.id,
                itemEntity.price,
                coloringBookEntity.theme,
                coloringBookEntity.numberOfDrawings,
                coloringBookEntity.numberOfDrawingCompleted
        );
    }
}
