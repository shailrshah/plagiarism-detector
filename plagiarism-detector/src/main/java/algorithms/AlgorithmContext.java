package algorithms;

import java.util.List;

import parser.Node;

/**
 * An object of AlgorithmContext is able to set the strategy
 * and execute it on two ASTs to compute their similarities
 */
public class AlgorithmContext {
	
	private AlgorithmStrategy strategy;

	/**
	 * Constructor for making a new AlgorithmContext
	 * @param strategy the strategy to be employed to
	 *                   compute the similarity between two Node lists
	 */
	public AlgorithmContext(AlgorithmStrategy strategy){
		this.strategy=strategy;
	}

	public Result executeStrategy(List<Node> list1, List<Node> list2){
		return strategy.computeSimilarity(list1, list2);
	}

}
