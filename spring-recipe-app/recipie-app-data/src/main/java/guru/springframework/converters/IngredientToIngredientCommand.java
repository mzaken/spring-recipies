/**
 * 
 */
package guru.springframework.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.model.Ingredient;
import lombok.Synchronized;

/**
 * @author Maor Zaken Created on 26 Jan 2020
 */
@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

	private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;

	public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomConverter) {
		this.uomConverter = uomConverter;
	}

	@Synchronized
	@Nullable
	@Override
	public IngredientCommand convert(Ingredient source) {
		if (source == null) {
			return null;
		}

		IngredientCommand ingredientCommand = new IngredientCommand();
		ingredientCommand.setDescription(source.getDescription());
		ingredientCommand.setAmount(source.getAmount());
		ingredientCommand.setId(source.getId());
		
		if (source.getRecipe() != null) {
			ingredientCommand.setRecipeId(source.getRecipe().getId());
		}
		ingredientCommand.setUom(uomConverter.convert(source.getUom()));

		return ingredientCommand;
	}

}
