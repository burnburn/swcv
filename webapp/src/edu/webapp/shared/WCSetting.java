package edu.webapp.shared;

import java.io.Serializable;
import java.util.Random;

/**
 * @author spupyrev
 *         Aug 17, 2013
 */
public class WCSetting implements Serializable
{
    private static final long serialVersionUID = 5465297978880066047L;

    public WCSetting()
    {
    }

    public enum CLUSTER_ALGORITHM
    {
        RANDOM, WORD_RANK, KMEANS, SENTIMENT, DYNAMIC
    }

    public enum COLOR_SCHEME
    {
        BLACK, GREEN, ORANGE, BLUE, BREWER_1, BREWER_2, BREWER_3, SIMILAR_1, SIMILAR_2, SIMILAR_3, TRISCHEME_1, TRISCHEME_2, TRISCHEME_3, BEAR_DOWN, SENTIMENT, SENTIMENT2, REDBLUEBLACK, BLUEREDBLACK, ORANGESEQUENTIAL, BLUESEQUENTIAL, GREENSEQUENTIAL
    }

    public enum LAYOUT_ALGORITHM
    {
        WORDLE, CPWCV, SEAM, INFLATE, STAR, CYCLE, MDS
    }

    public enum SIMILARITY_ALGORITHM
    {
        COSINE, JACCARD, LEXICAL, MATRIXDIS
    }

    public enum RANKING_ALGORITHM
    {
        TF, TF_IDF, LEX
    }

    public enum ASPECT_RATIO
    {
        AR11, AR43, AR169, AR219
    }

    private CLUSTER_ALGORITHM clusterAlgorithm = CLUSTER_ALGORITHM.KMEANS;
    private COLOR_SCHEME colorScheme = COLOR_SCHEME.BREWER_2;
    private LAYOUT_ALGORITHM layoutAlgorithm = LAYOUT_ALGORITHM.CPWCV;
    private SIMILARITY_ALGORITHM similarityAlgorithm = SIMILARITY_ALGORITHM.COSINE;
    private RANKING_ALGORITHM rankingAlgorithm = RANKING_ALGORITHM.TF;
    private WCFont font = WCFontCollection.getDefault();
    private ASPECT_RATIO aspectRatio = ASPECT_RATIO.AR169;

    private int wordCount = 50;

    public void setRandomSetting()
    {
        Random dice = new Random();
        int pick;

        setWordCount(this.getWordCount());

        pick = dice.nextInt(CLUSTER_ALGORITHM.values().length);
        setClusterAlgorithm(CLUSTER_ALGORITHM.values()[pick]);

        pick = dice.nextInt(COLOR_SCHEME.values().length);
        setColorScheme(COLOR_SCHEME.values()[pick]);

        pick = dice.nextInt(LAYOUT_ALGORITHM.values().length);
        setLayoutAlgorithm(LAYOUT_ALGORITHM.values()[pick]);

        pick = dice.nextInt(SIMILARITY_ALGORITHM.values().length);
        setSimilarityAlgorithm(SIMILARITY_ALGORITHM.values()[pick]);

        pick = dice.nextInt(RANKING_ALGORITHM.values().length);
        setRankingAlgorithm(RANKING_ALGORITHM.values()[pick]);

        setFont(WCFontCollection.getRandom());

        pick = dice.nextInt(ASPECT_RATIO.values().length);
        setAspectRatio(ASPECT_RATIO.values()[pick]);
    }

    public CLUSTER_ALGORITHM getClusterAlgorithm()
    {
        return clusterAlgorithm;
    }

    public void setClusterAlgorithm(CLUSTER_ALGORITHM clusterAlgorithm)
    {
        this.clusterAlgorithm = clusterAlgorithm;
    }

    public COLOR_SCHEME getColorScheme()
    {
        return colorScheme;
    }

    public void setColorScheme(COLOR_SCHEME colorScheme)
    {
        this.colorScheme = colorScheme;
    }

    public LAYOUT_ALGORITHM getLayoutAlgorithm()
    {
        return layoutAlgorithm;
    }

    public void setLayoutAlgorithm(LAYOUT_ALGORITHM layoutAlgorithm)
    {
        this.layoutAlgorithm = layoutAlgorithm;
    }

    public SIMILARITY_ALGORITHM getSimilarityAlgorithm()
    {
        return similarityAlgorithm;
    }

    public void setSimilarityAlgorithm(SIMILARITY_ALGORITHM similarityAlgorithm)
    {
        this.similarityAlgorithm = similarityAlgorithm;
    }

    public int getWordCount()
    {
        return wordCount;
    }

    public void setWordCount(int wordCount)
    {
        this.wordCount = wordCount;
    }

    public RANKING_ALGORITHM getRankingAlgorithm()
    {
        return rankingAlgorithm;
    }

    public void setRankingAlgorithm(RANKING_ALGORITHM rankingAlgorithm)
    {
        this.rankingAlgorithm = rankingAlgorithm;
    }

    public WCFont getFont()
    {
        return font;
    }

    public void setFont(WCFont font)
    {
        this.font = font;
    }

    public ASPECT_RATIO getAspectRatio()
    {
        return aspectRatio;
    }

    public double getAspectRatioDouble()
    {
        if (aspectRatio == ASPECT_RATIO.AR11)
            return 1.0;
        if (aspectRatio == ASPECT_RATIO.AR43)
            return 4.0 / 3.0;
        if (aspectRatio == ASPECT_RATIO.AR169)
            return 16.0 / 9.0;
        if (aspectRatio == ASPECT_RATIO.AR219)
            return 21.0 / 9.0;

        return 1.0;
    }

    public void setAspectRatio(ASPECT_RATIO ar)
    {
        this.aspectRatio = ar;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nwordCount:  " + wordCount + "\n");
        sb.append("layout:     " + layoutAlgorithm + "\n");
        sb.append("similarity: " + similarityAlgorithm + "\n");
        sb.append("ranking:    " + rankingAlgorithm + "\n");
        sb.append("colorTheme: " + colorScheme + "\n");
        sb.append("colorDistr: " + clusterAlgorithm + "\n");
        sb.append("font: " + font.getName() + "\n");
        sb.append("aspectRatio: " + aspectRatio + "\n");
        return sb.toString();
    }
}
