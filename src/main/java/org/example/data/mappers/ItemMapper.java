package org.example.data.mappers;

import org.example.data.entities.*;
import org.example.data.models.*;

public class ItemMapper {
    private ItemMapper() {}

    public static Item asItem(ItemEntity entity) {
        return new Item(entity.getId(), entity.getPrice());
    }
    public static ItemEntity asEntity(Item item) {
        return new ItemEntity(item.getId(), item.getPrice());
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
    public static BookEntity asEntity(Book item) {
        return new BookEntity(item.getId(), item.getTitle(), item.getAuthor(), item.getNumberOfPages(), item.getNumberOfPagesRead());
    }

    public static ColoringBook asDrawingBook(ItemEntity itemEntity, ColoringBookEntity coloringBookEntity) {
        return new ColoringBook(
                itemEntity.id,
                itemEntity.price,
                coloringBookEntity.theme,
                coloringBookEntity.numberOfDrawings,
                coloringBookEntity.numberOfDrawingCompleted
        );
    }
    public static ColoringBookEntity asEntity(ColoringBook item) {
        return new ColoringBookEntity(item.getId(), item.getTheme(), item.getNumberOfDrawings(), item.getNumberOfDrawingsCompleted());
    }

    public static Notebook asNotebook(ItemEntity itemEntity, NotebookEntity notebookEntity) {
        return new Notebook(
                itemEntity.id,
                itemEntity.price,
                notebookEntity.type,
                notebookEntity.numberOfPages,
                notebookEntity.numberOfPagesWritten
        );
    }
    public static NotebookEntity asEntity(Notebook item) {
        return new NotebookEntity(item.getId(), item.getType(), item.getNumberOfPages(), item.getNumberOfPagesWritten());
    }

    public static Cookbook asCookbook(ItemEntity itemEntity, CookbookEntity cookbookEntity) {
        return new Cookbook(
                itemEntity.id,
                itemEntity.price,
                cookbookEntity.skillLevel,
                cookbookEntity.numberOfRecipes,
                cookbookEntity.numberOfRecopesTried
        );
    }
    public static CookbookEntity asEntity(Cookbook item) {
        return new CookbookEntity(item.getId(), item.getSkillLevel(), item.getNumberOfRecipes(), item.getNumberOfRecipesTried());
    }

    public static InventoryItem asInventoryItem(ItemEntity entity, int count) {
        return new InventoryItem(ItemMapper.asItem(entity), count);
    }
}
