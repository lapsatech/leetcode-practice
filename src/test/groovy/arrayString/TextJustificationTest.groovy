package arrayString

import spock.lang.Specification
import spock.lang.Unroll

class TextJustificationTest extends Specification {

  @Unroll
  def 'test'(def words, def maxWidth, def String[] expect) {
    given:
    def s = new TextJustification();

    when:
    def res = s.fullJustify(words as String[], maxWidth) as String[]

    then:
    res == expect
    
    where:
    words               | maxWidth | expect
    [
      'This', 
      'is', 
      'an', 
      'example', 
      'of', 
      'text', 
      'justification.'
    ]                   | 16       | [
                                       'This    is    an',
                                       'example  of text',
                                       'justification.  '
                                      ]
    [
      'What',
      'must',
      'be',
      'acknowledgment',
      'shall',
      'be'
    ]                   | 16       | [
                                       'What   must   be',
                                       'acknowledgment  ',
                                       'shall be        '
                                     ]
    [
      'Science',
      'is',
      'what',
      'we',
      'understand',
      'well',
      'enough',
      'to',
      'explain',
      'to',
      'a',
      'computer.',
      'Art',
      'is',
      'everything',
      'else',
      'we',
      'do'
    ]                  | 20        | [
                                       'Science  is  what we',
                                       'understand      well',
                                       'enough to explain to',
                                       'a  computer.  Art is',
                                       'everything  else  we',
                                       'do                  '
                                     ]
    [
      'ask',
      'not',
      'what',
      'your',
      'country',
      'can',
      'do',
      'for',
      'you',
      'ask',
      'what',
      'you',
      'can',
      'do',
      'for',
      'your',
      'country'
     ]                  | 16        | [
                                        'ask   not   what',
                                        'your country can',
                                        'do  for  you ask',
                                        'what  you can do',
                                        'for your country'
                                      ]
  }
}