/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.deri.iris.parser.node;

import org.deri.iris.parser.analysis.Analysis;

@SuppressWarnings("nls")
public final class AAndLitlist extends PLitlist
{
    private PLitlist _litlist_;
    private TTAnd _tAnd_;
    private PLiteral _literal_;

    public AAndLitlist()
    {
        // Constructor
    }

    public AAndLitlist(
        @SuppressWarnings("hiding") PLitlist _litlist_,
        @SuppressWarnings("hiding") TTAnd _tAnd_,
        @SuppressWarnings("hiding") PLiteral _literal_)
    {
        // Constructor
        setLitlist(_litlist_);

        setTAnd(_tAnd_);

        setLiteral(_literal_);

    }

    @Override
    public Object clone()
    {
        return new AAndLitlist(
            cloneNode(this._litlist_),
            cloneNode(this._tAnd_),
            cloneNode(this._literal_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAndLitlist(this);
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

    public TTAnd getTAnd()
    {
        return this._tAnd_;
    }

    public void setTAnd(TTAnd node)
    {
        if(this._tAnd_ != null)
        {
            this._tAnd_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tAnd_ = node;
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
            + toString(this._tAnd_)
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

        if(this._tAnd_ == child)
        {
            this._tAnd_ = null;
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

        if(this._tAnd_ == oldChild)
        {
            setTAnd((TTAnd) newChild);
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
