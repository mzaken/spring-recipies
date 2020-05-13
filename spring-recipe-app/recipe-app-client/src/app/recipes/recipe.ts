import { Category } from '../categories/category';
import { Notes } from './notes';
import { Ingredient } from '../ingredients/ingredient';

export class Recipe {
    id: number;
    description: string;
    prepTime: number;
    cookTime: number;
    servings: number;
    source: string;
    url: string;
    imgUrl: string;
    notes: Notes;
    categories: Category[];
    image: string;
    directions: string;
    difficulty: string;
    ingredients: Ingredient[];
}
