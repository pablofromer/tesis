/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.deri.iris.parser.node;

import org.deri.iris.parser.analysis.Analysis;

@SuppressWarnings("nls")
public final class ACommaLitlist extends PLitlist
{
    private PLitlist _litlist_;
    private TTComma _tComma_;
    private PLiteral _literal_;

    public ACommaLitlist()
    {
        // Constructor
    }

    public ACommaLitlist(
        @SuppressWarnings("hiding") PLitlist _litlist_,
        @SuppressWarnings("hiding") TTComma _tComma_,
        @SuppressWarnings("hiding") PLiteral _literal_)
    {
        // Constructor
        setLitlist(_litlist_);

        setTComma(_tComma_);

        setLiteral(_literal_);

    }

    @Override
    public Object clone()
    {
        return new ACommaLitlist(
            cloneNode(this._litlist_),
            cloneNode(this._tComma_),
            cloneNode(this._literal_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACommaLitlist(this);
    }

    public PLitlist getLitlist()
    {
        return this._litlist_;
    }

    public void setLitlist(PLitlist node)
    {
        if(this._litlist_ != null)
        {
            this._litlist_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._litlist_ = node;
    }

    public TTComma getTComma()
    {
        return this._tComma_;
    }

    public void setTComma(TTComma node)
    {
        if(this._tComma_ != null)
        {
            this._tComma_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tComma_ = node;
    }

    public PLiteral getLiteral()
    {
        return this._literal_;
    }

    public void setLiteral(PLiteral node)
    {
        if(this._literal_ != null)
        {
            this._literal_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._literal_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._litlist_)
            + toString(this._tComma_)
            + toString(this._literal_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._litlist_ == child)
        {
            this._litlist_ = null;
            return;
        }

        if(this._tComma_ == child)
        {
            this._tComma_ = null;
            return;
        }

        if(this._literal_ == child)
        {
            this._literal_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._litlist_ == oldChild)
        {
            setLitlist((PLitlist) newChild);
            return;
        }

        if(this._tComma_ == oldChild)
        {
            setTComma((TTComma) newChild);
            return;
        }

        if(this._literal_ == oldChild)
        {
            setLiteral((PLiteral) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
